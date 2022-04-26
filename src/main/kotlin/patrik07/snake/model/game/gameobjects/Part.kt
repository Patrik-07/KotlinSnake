package patrik07.snake.model.game.gameobjects

import patrik07.snake.model.game.Snake

class Part(x: Int, y: Int) : GameObject(x, y) {
    var direction: Int = 0
    override fun collideWithSnake(snake: Snake) {
        snake.isAlive = false
    }
}