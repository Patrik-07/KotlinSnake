package patrik07.snake.view.game.map

import patrik07.snake.view.game.common.grid.GridView
import patrik07.snake.model.game.Map
import patrik07.snake.view.game.common.tile.Tile
import tornadofx.*

class MapView(map: Map) : GridView(map) {
    init {
        update(map)
    }

    fun update(map: Map) {
        grid.clear()
        for (row in 0 until map.rowCount) {
            for (col in 0 until map.colCount) {
                val gameObject = map[row, col]
                val tile = Tile.get(gameObject)
                grid[row, col] = tile?.create()
            }
        }
    }
}