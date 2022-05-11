package patrik07.snake.model.game

import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.gameobject.gameobjects.Empty
import patrik07.snake.model.game.gameobject.gameobjects.Wall

class Map {
    companion object {
        var rowCount = 0
        var colCount = 0

        private var gameObject2DArray: Array<Array<GameObject>> = Array(rowCount) {
            Array(colCount) { Empty() }
        }

        fun reset(rowCount: Int, colCount: Int) {
            Companion.rowCount = rowCount
            Companion.colCount = colCount

            gameObject2DArray = Array(Companion.rowCount) {
                Array(Companion.colCount) { Empty() }
            }
        }

        fun clear() {
            for (row in 0 until rowCount) {
                for (col in 0 until colCount) {
                    if (gameObject2DArray[row][col] !is Wall) {
                        gameObject2DArray[row][col] = Empty()
                    }
                }
            }
        }

        operator fun get(row: Int, col: Int): GameObject {
            return gameObject2DArray[row][col]
        }

        operator fun set(row: Int, col: Int, gameObject: GameObject) {
            gameObject2DArray[row][col] = gameObject
        }
    }
}