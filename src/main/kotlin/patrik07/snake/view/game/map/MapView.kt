package patrik07.snake.view.game.map

import patrik07.snake.view.game.common.grid.GridView
import patrik07.snake.view.game.common.tile.tiles.PartTile
import tornadofx.*

class MapView : GridView() {
    init {
        update()
    }

    fun update() {
        grid.clear()
        PartTile.index = 1

        for (row in 0 until gameController.rowCount) {
            for (col in 0 until gameController.colCount) {
                val tile = gameController.getTile(row, col)
                grid[row, col] = tile
            }
        }
    }
}