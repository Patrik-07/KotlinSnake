package patrik07.snake.model.leaderboard

class Leaderboard {
    companion object {
        val instance = Leaderboard()
    }

    var players : MutableList<Player> = ArrayList()

    fun addPlayer(player: Player) {
        players.add(player)
        players.sortBy { it.score }
    }
}