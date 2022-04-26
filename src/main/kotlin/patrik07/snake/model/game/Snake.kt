package patrik07.snake.model.game

import patrik07.snake.model.game.gameobjects.Part

class Snake(initialDirection: Int, length: Int) {
    companion object {
        val instance = Snake(Direction.RIGHT, 3)
    }

    var isAlive = true
    var body: MutableList<Part> = ArrayList()

    var direction: Int = initialDirection
        set(value) {
            body[0].direction = value
            field = value
        }

    init {
//        for (i in 0 until length)
//            body.add(Part(direction))
    }

    fun grow() {
//        val lastPart = body.last()
//        val dir = lastPart.direction
//
//        body.add(Part(dir))
    }

    fun move() {

    }
}