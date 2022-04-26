package patrik07.snake.model.game.gameobjects

import patrik07.snake.model.game.Snake

class Grass2(x: Int, y: Int) : GameObject(x, y) {
    override fun collideWithSnake(snake: Snake) {}
}