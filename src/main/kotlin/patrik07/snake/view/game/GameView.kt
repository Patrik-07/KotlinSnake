package patrik07.snake.view.game

import javafx.scene.layout.*
import patrik07.snake.controller.game.SnakeController
import patrik07.snake.view.game.map.BackgroundView
import tornadofx.*

class GameView : View() {
    private val snakeController: SnakeController by inject()

    private val snakeView = SnakeView()

    private var pane = Pane()

    override val root = pane

    init {
        pane.setOnKeyPressed {
            snakeController.handleKeyEvent(it)
        }

        pane.add(snakeView)
    }

    override fun onDock() {
        super.onDock()
        pane.requestFocus()
    }
}