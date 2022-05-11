package patrik07.snake.model.game

import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.gameobject.gameobjects.Empty

class Map {
    companion object {
        var rowCount = 0
        var colCount = 0

        private var gameObjects: Array<Array<GameObject>> = Array(rowCount) {
            Array(colCount) { Empty() }
        }

        fun reset(rowCount: Int, colCount: Int) {
            Companion.rowCount = rowCount
            Companion.colCount = colCount

            gameObjects = Array(Companion.rowCount) {
                Array(Companion.colCount) { Empty() }
            }
        }

        operator fun get(row: Int, col: Int): GameObject {
            return gameObjects[row][col]
        }

        operator fun set(row: Int, col: Int, gameObject: GameObject) {
            gameObjects[row][col] = gameObject
        }
    }
}