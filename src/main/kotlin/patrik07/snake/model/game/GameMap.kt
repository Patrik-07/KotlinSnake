package patrik07.snake.model.game

import patrik07.snake.model.game.gameobjects.*

class GameMap(size: Int) {
    val map: Array<Array<GameObject>> = Array(size) { Array(size) { Grass1(0, 0) } }

    init {
        var row = arrayOf<GameObject>()
        for (i in 0 until size) {
            row += Wall(0, i)
        }
        map[0] = row
        println("asd")

        for (i in 0 until size) {
            map[i][0] = Wall(i, 0)
        }

        for (i in 0 until size) {
            map[size-1][i] = Wall(size-1, i)
        }
        for (i in 0 until size) {
            map[i][size-1] = Wall(i, size-1)
        }

        for (i in 1 until size - 1) {
            for (j in 1 until size - 1) {
                if ((i + j) % 2 == 0) {
                    map[i][j] = Grass1(i, j);
                } else map[i][j] = Grass2(i, j);
            }
        }
    }
}