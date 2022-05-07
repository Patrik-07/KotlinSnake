package patrik07.snake.controller.game

import patrik07.snake.model.game.Map
import patrik07.snake.model.game.gameobject.gameobjects.*
import patrik07.snake.view.game.common.tile.Tile
import tornadofx.*
import java.io.File
import java.io.InputStream

class MapController : Controller() {
    lateinit var map: Map

    val rowCount: Int
        get() = map.rowCount
    val colCount: Int
        get() = map.colCount


    fun update() {

    }

    fun getTile(row: Int, col: Int): Tile? {
        val gameObject = map[row, col]
        return Tile.get(gameObject)
    }

    fun setMapFromStringResources(path: String) {
        map = parseStringToMap(path)
    }

    private fun parseStringToMap(path: String): Map {
        val inputStream: InputStream = File(path).inputStream()
        val lines = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { lines.add(it) }

        var maxColCount = 0

        for (row in lines) {
            if (maxColCount < row.length) {
                maxColCount = row.length
            }
        }

        val rowCount = lines.size
        val colCount = maxColCount
        val map = Map(rowCount, colCount)

        for (row in 0 until colCount) {
            for (col in 0 until lines[row].length) {
                when (lines[row][col]) {
                    '#' -> map[row, col] = Wall()
                    ' ' -> map[row, col] = Empty()
                    'S' -> map[row, col] = Head()
                }
            }
        }

        return map
    }
}