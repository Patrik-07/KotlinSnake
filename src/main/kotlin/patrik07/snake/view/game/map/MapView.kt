package patrik07.snake.view.game.map

import patrik07.snake.view.game.common.grid.GridView
import tornadofx.*

class MapView : GridView() {
    init {
        update()
    }

    fun update() {
        mapController.update()
        grid.clear()

        for (row in 0 until mapController.rowCount) {
            for (col in 0 until mapController.colCount) {
                val tile = mapController.getTile(row, col)
                grid[row, col] = tile?.create()
            }
        }
    }
}