package patrik07.snake.model.game.gameobjects

import patrik07.snake.model.game.GameObject
import patrik07.snake.model.game.snake.Snake

class Wall : GameObject() {
    override fun collideWithSnake(snake: Snake) {
        snake.isAlive = false
    }
}