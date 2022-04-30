package patrik07.snake.model.game.gameobject.gameobjects

import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.snake.Snake

open class Part : GameObject() {
    override fun collideWithSnake(snake: Snake) {
        snake.isAlive = false
    }
}