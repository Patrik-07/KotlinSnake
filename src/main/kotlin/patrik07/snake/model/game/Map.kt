package patrik07.snake.model.game

import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.gameobject.gameobjects.Empty

class Map(val rowCount: Int, val colCount: Int) {
    private val map: Array<Array<GameObject>> = Array(rowCount) {
        Array(colCount) { Empty() }
    }

    operator fun get(row: Int, col: Int): GameObject {
        return map[row][col]
    }

    operator fun set(row: Int, col: Int, gameObject: GameObject) {
        map[row][col] = gameObject
    }
}