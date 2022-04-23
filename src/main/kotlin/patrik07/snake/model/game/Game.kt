package patrik07.snake.model.game

class Game {
    //val map = Array(row) { IntArray(column) }
    val snake = Snake.instance

    fun update() {
        snake.move()
    }
}