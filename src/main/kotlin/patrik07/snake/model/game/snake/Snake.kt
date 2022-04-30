package patrik07.snake.model.game.snake

class Snake {
    companion object {
        val instance = Snake()
    }

    var isAlive = true
    var direction: Int = Direction.RIGHT
}