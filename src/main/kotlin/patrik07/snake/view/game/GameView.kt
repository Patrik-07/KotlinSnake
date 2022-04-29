package patrik07.snake.view.game

import javafx.scene.layout.*
import tornadofx.*

class GameView : View() {
    private var pane = Pane()
    private var snakeView: SnakeView
    override val root = pane

    init {
        pane.add(MapView())

        snakeView = SnakeView()
        pane.add(snakeView)
    }

    override fun onDock() {
        super.onDock()
        snakeView.grid.requestFocus()
    }
}