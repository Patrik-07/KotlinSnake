package patrik07.snake.model.game.gameobject.gameobjects

import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.snake.Direction
import patrik07.snake.model.game.snake.Snake

open class Part(var x: Int, var y: Int) : GameObject() {
    var index: Int = 0

    companion object {
        private var count = 0
    }

    init {
        index = count++
    }

    override fun collideWithSnake() {
        Snake.isAlive = false
    }
}