package patrik07.snake.view.game.common.grid

import patrik07.snake.controller.GameController
import tornadofx.*

open class GridView : View() {
    protected val gameController: GameController by inject()

    val grid = Grid(gameController.rowCount, gameController.colCount)
    override val root = grid
}