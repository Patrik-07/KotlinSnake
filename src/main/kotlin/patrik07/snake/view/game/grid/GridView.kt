package patrik07.snake.view.game.grid

import patrik07.snake.controller.game.MapController
import tornadofx.*

open class GridView : View() {
    private val mapController: MapController by inject()
    val grid = Grid(mapController.map)

    override val root = grid

    fun update() {
        grid.update(mapController.map)
    }
}