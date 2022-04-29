package patrik07.snake.controller.game

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import patrik07.snake.model.game.snake.Direction
import patrik07.snake.model.game.snake.Snake
import tornadofx.*

class SnakeController : Controller() {
    val snake = Snake.instance

    fun handleKeyEvent(keyEvent: KeyEvent) {
        when (keyEvent.code) {
            KeyCode.W, KeyCode.UP -> snake.direction = Direction.UP
            KeyCode.A, KeyCode.LEFT -> snake.direction = Direction.LEFT
            KeyCode.S, KeyCode.DOWN -> snake.direction = Direction.DOWN
            KeyCode.D, KeyCode.RIGHT -> snake.direction = Direction.RIGHT
            KeyCode.E -> {
                println("asd")
            }
            else -> {}
        }
    }
}