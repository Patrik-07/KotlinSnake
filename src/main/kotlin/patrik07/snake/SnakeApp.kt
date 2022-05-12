package patrik07.snake

import javafx.stage.Stage
import kotlinx.serialization.ExperimentalSerializationApi
import patrik07.snake.controller.GameController
import patrik07.snake.view.menu.MenuView
import tornadofx.*

@ExperimentalSerializationApi
class SnakeApp: App(MenuView::class) {
    private val gameController: GameController by inject()

    override fun start(stage: Stage) {
        super.start(stage)
        gameController.readPlayers()
        gameController.setMapFromStringResources("maps/easy.txt")
    }

    override fun stop() {
        super.stop()
        gameController.savePlayers()
    }
}

@ExperimentalSerializationApi
fun main() {
    launch<SnakeApp>()
}