package patrik07.snake.view.game.map

import patrik07.snake.model.game.Map
import patrik07.snake.view.game.common.grid.GridView
import patrik07.snake.view.game.common.tile.tiles.GrassDarkTile
import patrik07.snake.view.game.common.tile.tiles.GrassLightTile

class BackgroundView(map: Map) : GridView(map) {
    init {
        for (row in 0 until map.rowCount) {
            for (col in 0 until map.colCount) {
                if ((row + col) % 2 == 0) {
                    grid[row, col] = GrassDarkTile()
                } else grid[row, col] = GrassLightTile()
            }
        }
    }
}