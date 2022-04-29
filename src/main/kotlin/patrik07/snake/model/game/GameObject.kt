package patrik07.snake.model.game

import patrik07.snake.model.game.snake.Snake

abstract class GameObject {
    abstract fun collideWithSnake(snake: Snake)
}