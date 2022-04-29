package patrik07.snake.view.game.grid

import patrik07.snake.model.game.Map
import tornadofx.*

open class GridView(map: Map) : View() {
    val grid = MapGrid(map)

    override val root = grid

    fun update(map: Map) {
        grid.update(map)
    }
}