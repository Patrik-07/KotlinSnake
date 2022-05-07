package patrik07.snake.view.game

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import patrik07.snake.controller.game.MapController
import patrik07.snake.model.game.Game
import patrik07.snake.view.game.map.BackgroundView
import patrik07.snake.view.game.map.MapView
import tornadofx.*

class SnakeView : View() {
    val game = Game.instance

    private val backgroundView = BackgroundView()
    private val mapView = MapView()

    override val root = pane {
        add(backgroundView)
        add(mapView)

        val timeline = Timeline(
            KeyFrame(1.seconds, {
                mapView.update()
            })
        )
        timeline.cycleCount = Animation.INDEFINITE
        timeline.play()
    }
}