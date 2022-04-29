package patrik07.snake.model.game

import patrik07.snake.model.game.gameobjects.*
import patrik07.snake.model.game.snake.Head
import patrik07.snake.model.game.snake.Part

class Map(val rowCount: Int, val colCount: Int) {
    private val map: Array<Array<GameObject>> = Array(rowCount) {
        Array(colCount) { Empty() }
    }

    private val snakePositions = listOf(
        Head(),
        Part(),
        Part()
    )

    operator fun get(row: Int, col: Int): GameObject {
        return map[row][col]
    }

    operator fun set(row: Int, col: Int, gameObject: GameObject) {
        map[row][col] = gameObject
    }

    fun update() {

    }
}