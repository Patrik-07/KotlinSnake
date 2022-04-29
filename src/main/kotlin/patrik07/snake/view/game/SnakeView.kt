package patrik07.snake.view.game

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import patrik07.snake.controller.game.MapController
import patrik07.snake.controller.game.SnakeController
import patrik07.snake.view.game.grid.GridView

import tornadofx.*

class SnakeView : GridView() {
    private val snakeController: SnakeController by inject()

    init {
        grid.setOnKeyPressed {
            snakeController.handleKeyEvent(it)
        }

        val timeline = Timeline(
            KeyFrame(1.seconds, {
                update()
            })
        )
        timeline.cycleCount = Animation.INDEFINITE
        timeline.play()
    }
}