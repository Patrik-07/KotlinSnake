package patrik07.snake.model.game

import patrik07.snake.model.game.gameobjects.*

class Map(val rowCount: Int, val colCount: Int) {
    val map: Array<Array<GameObject>> = Array(rowCount) {
        Array(colCount) { Empty(0, 0) }
    }

    init {
        for (row in 0 until rowCount)
            for (col in 0 until colCount)
                map[row][col] = Empty(row, col)
    }

    /*
    init {
        // top
        for (i in 0 until rowCount) {
            map[i][0] = Wall(i, 0)
        }
        // left
        for (i in 0 until colCount) {
            map[0][i] = Wall(0, i)
        }
        // right
        for (i in 0 until colCount) {
            map[rowCount-1][i] = Wall(rowCount-1, i)
        }
        // bottom
        for (i in 0 until rowCount) {
            map[i][colCount-1] = Wall(i, colCount-1)
        }

        for (i in 1 until rowCount - 1) {
            for (j in 1 until colCount - 1) {
                if ((i + j) % 2 == 0) {
                    map[i][j] = GrassLight(i, j);
                } else map[i][j] = GrassDark(i, j);
            }
        }
    }
     */

    fun update() {

    }
}