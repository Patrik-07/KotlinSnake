package patrik07.snake

import javafx.stage.Stage
import patrik07.snake.controller.game.MapController
import patrik07.snake.view.main.MenuView
import tornadofx.*
import patrik07.snake.controller.leaderboard.LeaderboardController
import patrik07.snake.model.game.Game

class SnakeApp: App(MenuView::class) {
    private val leaderboardController: LeaderboardController by inject()
    private val mapController: MapController by inject()

    override fun start(stage: Stage) {
        super.start(stage)
        leaderboardController.readPlayers()
        mapController.setMapFromStringResources("maps/map01.txt")
    }

    override fun stop() {
        super.stop()
        leaderboardController.savePlayers()
    }
}

fun main() {
    launch<SnakeApp>()
}