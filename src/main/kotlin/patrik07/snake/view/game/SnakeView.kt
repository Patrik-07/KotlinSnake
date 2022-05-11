package patrik07.snake.view.game

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import patrik07.snake.model.game.snake.Snake
import patrik07.snake.view.game.map.BackgroundView
import patrik07.snake.view.game.map.MapView
import tornadofx.*

class SnakeView : View() {
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