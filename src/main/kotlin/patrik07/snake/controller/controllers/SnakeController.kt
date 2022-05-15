package patrik07.snake.controller.controllers

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import patrik07.snake.model.game.snake.Direction
import patrik07.snake.model.game.snake.Snake
import tornadofx.*

class SnakeController : Controller() {
    fun resetSnake() {
        Snake.reset()
    }

    fun updateSnake(): Boolean {
        if (Snake.isAlive)
            Snake.update()
        return Snake.isAlive
    }

    fun handleKeyEvent(keyEvent: KeyEvent) {
        when (keyEvent.code) {
            KeyCode.W, KeyCode.UP -> {
                if (Snake.direction != Direction.DOWN) {
                    Snake.nextDirection = Direction.UP
                }
            }
            KeyCode.A, KeyCode.LEFT -> {
                if (Snake.direction != Direction.RIGHT) {
                    Snake.nextDirection = Direction.LEFT
                }
            }
            KeyCode.S, KeyCode.DOWN -> {
                if (Snake.direction != Direction.UP) {
                    Snake.nextDirection = Direction.DOWN
                }
            }
            KeyCode.D, KeyCode.RIGHT -> {
                if (Snake.direction != Direction.LEFT) {
                    Snake.nextDirection = Direction.RIGHT
                }
            }
            else -> {}
        }
    }

    fun getSnakeLength(): Int {
        return Snake.length
    }

    fun getSnakeInitialLength(): Int {
        return Snake.initialLength
    }
}