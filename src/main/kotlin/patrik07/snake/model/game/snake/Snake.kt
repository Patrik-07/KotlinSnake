package patrik07.snake.model.game.snake

import patrik07.snake.model.game.gameobject.gameobjects.Head
import patrik07.snake.model.game.gameobject.gameobjects.Part

class Snake(val initialLength: Int) {
    companion object {
        val instance = Snake(3)
    }

    private val body = ArrayList<Part>()
    var isAlive = true
    var direction: Int = Direction.RIGHT
    val length get() = body.size

    fun reset() {
        body.clear()
        body.add(Head(0, 0))
        body.add(Part(0, 0))
        body.add(Part(0, 0))
        isAlive = true
    }

    fun update(): Boolean {
        move()
        return isAlive
    }

    private fun grow() {

    }

    private fun move() {
        var lastX = body[0].x
        var lastY = body[0].y
        for (i in 1 until body.size) {
            val currentX = body[i].x
            val currentY = body[i].y
            body[i].x = lastX
            body[i].y = lastY
            lastX = currentX
            lastY = currentY
        }

        when (direction) {
            Direction.UP -> body[0].y--
            Direction.LEFT -> body[0].x--
            Direction.DOWN -> body[0].y++
            Direction.RIGHT -> body[0].x--
        }
    }
}