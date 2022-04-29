package patrik07.snake.model.game.snake

import patrik07.snake.model.game.gameobjects.Part

class Snake {
    companion object {
        val instance = Snake()
    }

    var isAlive = true
    var body: MutableList<Part> = ArrayList()
}