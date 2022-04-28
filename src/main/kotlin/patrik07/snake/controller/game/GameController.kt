package patrik07.snake.controller.game

import javafx.scene.input.KeyCode
import tornadofx.*
import javafx.scene.input.KeyEvent
import patrik07.snake.model.game.Game
import patrik07.snake.model.game.Map

class GameController : Controller() {
    private val game = Game.instance

    fun handleKeyEvent(keyEvent: KeyEvent) {
        when (keyEvent.code) {
//            KeyCode.W, KeyCode.UP -> snake.direction = Direction.UP
//            KeyCode.A, KeyCode.LEFT -> snake.direction = Direction.LEFT
//            KeyCode.S, KeyCode.DOWN -> snake.direction = Direction.DOWN
//            KeyCode.D, KeyCode.RIGHT -> snake.direction = Direction.RIGHT
            KeyCode.E -> {
                game.over()
                println("asd")
            }
            else -> {}
        }
    }

    fun getGameMap(): Map {
        return game.map
    }
}