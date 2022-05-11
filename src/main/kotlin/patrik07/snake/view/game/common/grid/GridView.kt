package patrik07.snake.view.game.common.grid

import patrik07.snake.controller.game.GameController
import patrik07.snake.controller.game.MapController
import tornadofx.*

open class GridView : View() {
    protected val mapController: MapController by inject()

    val grid = Grid(mapController.rowCount, mapController.colCount)
    override val root = grid
}