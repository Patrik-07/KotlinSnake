package patrik07.snake.model.leaderboard

import kotlinx.serialization.Serializable

@Serializable
class Player(val name: String, val score: Int) {
    companion object {
        var current = Player("", 0)
    }
}