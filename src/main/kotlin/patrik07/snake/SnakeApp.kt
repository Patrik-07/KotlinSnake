package patrik07.snake

import javafx.stage.Stage
import patrik07.snake.controller.game.MapController
import patrik07.snake.view.menu.MenuView
import tornadofx.*
import patrik07.snake.controller.leaderboard.LeaderboardController

class SnakeApp: App(MenuView::class) {
    private val leaderboardController: LeaderboardController by inject()
    private val mapController: MapController by inject()

    override fun start(stage: Stage) {
        super.start(stage)
        leaderboardController.readPlayers()
        mapController.setMapFromStringResources("maps/easy.txt")
    }

    override fun stop() {
        super.stop()
        leaderboardController.savePlayers()
    }

    fun initialize() {
        mapController.setMapFromStringResources("maps/easy.txt")
    }
}

fun main() {
    val snakeApp = SnakeApp()
    snakeApp.initialize()
    launch<SnakeApp>()
}