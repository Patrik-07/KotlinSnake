package patrik07.snake.model.game.gameobjects

import patrik07.snake.model.game.Snake

abstract class GameObject(var x: Int, var y: Int) {
    abstract fun collideWithSnake(snake: Snake)
}