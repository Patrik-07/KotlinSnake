package patrik07.snake

import javafx.stage.Stage
import patrik07.snake.view.main.MenuView
import tornadofx.*
import patrik07.snake.controller.LeaderboardController
import patrik07.snake.model.game.Game

class SnakeApp: App(MenuView::class) {
    private val controller: LeaderboardController by inject()
    private val game = Game()

    override fun start(stage: Stage) {
        super.start(stage)
        controller.readPlayers()
        game.start()
    }

    override fun stop() {
        super.stop()
        controller.savePlayers()
    }
}

fun main() {
    launch<SnakeApp>()
}