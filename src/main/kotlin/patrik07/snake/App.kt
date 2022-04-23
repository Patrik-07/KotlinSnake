package patrik07.snake

import javafx.stage.Stage
import kotlinx.serialization.encodeToString
import patrik07.snake.model.leaderboard.Leaderboard
import patrik07.snake.view.MenuView
import tornadofx.App
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeToSequence
import patrik07.snake.model.leaderboard.Player
import java.io.ByteArrayInputStream
import java.io.File

class App: App(MenuView::class) {
    private val leaderboard = Leaderboard.instance

    override fun start(stage: Stage) {
        super.start(stage)
        readPlayers()
    }

    override fun stop() {
        super.stop()
        savePlayers()
    }

    private fun readPlayers() {
        val players = Json.decodeToSequence<Player>(
            ByteArrayInputStream(
                File("resources/players.json").readBytes()
            )
        )

        leaderboard.players = players.toMutableList()
        leaderboard.players.sortBy { it.score }
        leaderboard.players.reverse()
    }

    private fun savePlayers() {
        var jsonString = "["

        val players = leaderboard.players
        players.forEach {
            jsonString += Json.encodeToString(it)
            if (players.last() != it)
                jsonString += ","
        }

        jsonString += "]"

        File("resources/players.json").writeBytes(
            jsonString.toByteArray()
        )
    }
}