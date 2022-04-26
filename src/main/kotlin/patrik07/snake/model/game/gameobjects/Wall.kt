package patrik07.snake.model.game.gameobjects

import patrik07.snake.model.game.Snake

class Wall(x: Int, y: Int) : GameObject(x, y) {
    override fun collideWithSnake(snake: Snake) {
        snake.isAlive = false
    }
}