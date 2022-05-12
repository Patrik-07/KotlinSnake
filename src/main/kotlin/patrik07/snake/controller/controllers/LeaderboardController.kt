package patrik07.snake.controller.controllers

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeToSequence
import patrik07.snake.model.leaderboard.Leaderboard
import patrik07.snake.model.leaderboard.Player
import tornadofx.*
import java.io.ByteArrayInputStream
import java.io.File

class LeaderboardController : Controller() {
    val leaderboard = Leaderboard.instance

    fun addPlayer(player: Player) {
        leaderboard.players.add(player)
        leaderboard.players.sortBy { it.score }
        leaderboard.players.reverse()
    }

    @kotlinx.serialization.ExperimentalSerializationApi
    fun readPlayers() {
        val players = Json.decodeToSequence<Player>(
            ByteArrayInputStream(
                File("players.json").readBytes()
            )
        )

        leaderboard.players = players.toMutableList()
        leaderboard.players.sortBy { it.score }
        leaderboard.players.reverse()
    }

    fun savePlayers() {
        var jsonString = "["

        val players = leaderboard.players
        for (i in 0 until players.size) {
            val player = players[i]
            jsonString += Json.encodeToString(player)
            if (i != players.size - 1)
                jsonString += ","
        }

        jsonString += "]"

        File("players.json").writeBytes(
            jsonString.toByteArray()
        )
    }
}