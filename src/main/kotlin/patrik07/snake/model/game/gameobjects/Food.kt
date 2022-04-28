package patrik07.snake.model.game.gameobjects

import patrik07.snake.model.game.snake.Snake

class Food(x: Int, y: Int) : GameObject(x, y) {
    override fun collideWithSnake(snake: Snake) {
        snake.grow()
    }
}