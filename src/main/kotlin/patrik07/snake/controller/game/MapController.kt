package patrik07.snake.controller.game

import patrik07.snake.model.game.Game
import patrik07.snake.model.game.Map
import patrik07.snake.model.game.gameobjects.GrassDark
import patrik07.snake.model.game.gameobjects.GrassLight
import patrik07.snake.model.game.gameobjects.Head
import patrik07.snake.model.game.gameobjects.Wall
import tornadofx.*
import java.io.File
import java.io.InputStream

class MapController : Controller() {
    private val game = Game.instance
    var map = game.map

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
                    'G' -> {
                        if ((row + col) % 2 == 0) {
                            map[row, col] = GrassLight()
                        } else map[row, col] = GrassDark()
                    }
                    'S' -> map[row, col] = Head()
                }
            }
        }

        return map
    }
}