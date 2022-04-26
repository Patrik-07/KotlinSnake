package patrik07.snake.controller

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeToSequence
import patrik07.snake.model.leaderboard.Leaderboard
import patrik07.snake.model.leaderboard.Player
import tornadofx.*
import java.io.ByteArrayInputStream
import java.io.File

class LeaderboardController : Controller() {
    private val leaderboard = Leaderboard.instance

    fun readPlayers() {
        val players = Json.decodeToSequence<Player>(
            ByteArrayInputStream(
                File("resources/players.json").readBytes()
            )
        )

        leaderboard.players = players.toMutableList()
        leaderboard.players.sortBy { it.score }
        leaderboard.players.reverse()
    }

    fun savePlayers() {
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