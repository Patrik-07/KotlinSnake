package patrik07.snake.model.game.gameobjects

import patrik07.snake.model.game.GameObject
import patrik07.snake.model.game.snake.Snake

// TODO should remove grass types from gameObjectss

class GrassLight : GameObject() {
    override fun collideWithSnake(snake: Snake) {}
}