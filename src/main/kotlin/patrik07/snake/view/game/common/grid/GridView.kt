package patrik07.snake.view.game.common.grid

import patrik07.snake.model.game.Map
import tornadofx.*

open class GridView(map: Map) : View() {
    val grid = Grid(map.rowCount, map.colCount)
    override val root = grid
}