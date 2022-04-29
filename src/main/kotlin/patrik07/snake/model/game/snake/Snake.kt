package patrik07.snake.model.game.snake

class Snake {
    companion object {
        val instance = Snake()
    }

    var isAlive = true
    var body: MutableList<Part> = ArrayList()
}