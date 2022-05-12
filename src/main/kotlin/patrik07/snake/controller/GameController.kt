package patrik07.snake.controller

import tornadofx.*
import javafx.scene.input.KeyEvent
import patrik07.snake.controller.controllers.LeaderboardController
import patrik07.snake.controller.controllers.MapController
import patrik07.snake.controller.controllers.SnakeController
import patrik07.snake.model.leaderboard.Player
import patrik07.snake.view.game.common.tile.Tile

class GameController : Controller() {
    private val snakeController: SnakeController by inject()
    private val mapController: MapController by inject()
    private val leaderboardController: LeaderboardController by inject()

    val rowCount get() = mapController.rowCount
    val colCount get() = mapController.colCount
    val players get() = leaderboardController.leaderboard.players

    fun resetGame() {
        snakeController.resetSnake()
        mapController.resetMap()
    }

    fun updateGame(): Boolean {
        return !snakeController.updateSnake()
    }

    fun handleKeyEvent(keyEvent: KeyEvent) {
        snakeController.handleKeyEvent(keyEvent)
    }

    fun getScore(): Int {
        val length = snakeController.getSnakeLength()
        val initialLength = snakeController.getSnakeInitialLength()

        return length - initialLength
    }

    fun getTile(row: Int, col: Int): Tile? {
        return mapController.getTile(row, col)
    }

    fun setMapFromStringResources(path: String) {
        mapController.setMapFromStringResources(path)
    }

    fun addPlayerToLeaderboard(player: Player) {
        leaderboardController.addPlayer(player)
    }

    @kotlinx.serialization.ExperimentalSerializationApi
    fun readPlayers() {
        leaderboardController.readPlayers()
    }

    fun savePlayers() {
        leaderboardController.savePlayers()
    }
}