package patrik07.snake.controller.controllers

import patrik07.snake.model.game.Map
import patrik07.snake.model.game.gameobject.gameobjects.Wall
import patrik07.snake.model.game.gameobject.gameobjects.Empty
import patrik07.snake.view.game.common.tile.Tile
import tornadofx.*
import java.io.File
import java.io.InputStream

class MapController : Controller() {
    val rowCount get() = Map.rowCount
    val colCount get() = Map.colCount

    fun resetMap() {
        Map.clearSnake()
    }

    fun getTile(row: Int, col: Int): Tile? {
        val gameObject = Map[row, col]
        return Tile.get(gameObject)
    }

    fun setMapFromStringResources(path: String) {
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
        Map.reset(rowCount, colCount)

        for (row in 0 until colCount) {
            for (col in 0 until lines[row].length) {
                when (lines[row][col]) {
                    '#' -> Map[row, col] = Wall()
                    ' ' -> Map[row, col] = Empty()
                }
            }
        }

        Map.spawnFood()
    }
}