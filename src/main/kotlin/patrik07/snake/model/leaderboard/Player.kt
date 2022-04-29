package patrik07.snake.model.leaderboard

import kotlinx.serialization.Serializable

@Serializable
data class Player(val name: String, val score: Int)