package patrik07.snake.model.game.gameobject.gameobjects

import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.snake.Snake

class Empty : GameObject() {
    override fun collideWithSnake() {}
}