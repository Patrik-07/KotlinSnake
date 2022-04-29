package patrik07.snake.model.game.snake

import patrik07.snake.model.game.GameObject
import patrik07.snake.model.game.snake.Snake

open class Part : GameObject() {
    override fun collideWithSnake(snake: Snake) {
        snake.isAlive = false
    }
}