package patrik07.snake.view.game

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import patrik07.snake.controller.game.MapController
import patrik07.snake.view.game.map.BackgroundView
import patrik07.snake.view.game.map.MapView
import tornadofx.*

class SnakeView : View() {
    private val mapController: MapController by inject()

    private val backgroundView = BackgroundView(mapController.map)
    private val mapView = MapView(mapController.map)

    override val root = pane {
        add(backgroundView)
        add(mapView)

        val timeline = Timeline(
            KeyFrame(1.seconds, {
                mapController.update()
                mapView.update(mapController.map)
            })
        )
        timeline.cycleCount = Animation.INDEFINITE
        timeline.play()
    }
}