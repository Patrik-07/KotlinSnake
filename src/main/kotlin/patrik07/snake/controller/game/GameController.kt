package patrik07.snake.controller.game

import tornadofx.*
import javafx.scene.input.KeyEvent

class GameController : Controller() {
    private val mapController: MapController by inject()
    private val snakeController: SnakeController by inject()

    fun resetGame() {
        snakeController.resetSnake()
    }

    fun updateGame(): Boolean {
        return !snakeController.updateSnake()
    }

    fun handleKeyEvent(keyEvent: KeyEvent) {
        snakeController.handleKeyEvent(keyEvent)
    }

    fun getScore(): Int {
        val length = snakeController.getSnakeLength()
        val initialLength = snakeController.getSnakeInitialLength()

        return length - initialLength
    }
}