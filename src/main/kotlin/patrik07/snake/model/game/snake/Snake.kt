package patrik07.snake.model.game.snake

import patrik07.snake.model.game.Map
import patrik07.snake.model.game.gameobject.gameobjects.Head
import patrik07.snake.model.game.gameobject.gameobjects.Part

class Snake {
    companion object {
        private val body = ArrayList<Part>()

        var isAlive = true
        var direction: Int = Direction.RIGHT

        const val initialLength = 20
        val length get() = body.size

        fun reset() {
            isAlive = true

            body.clear()
            val centerX = Map.rowCount / 2
            val centerY = Map.colCount / 2

            body.add(Head(centerX, centerY))
            for (i in 1 until initialLength)
                body.add(Part(centerX, centerY))
        }

        fun update(): Boolean {
            move()

            Map.clear()
            for (part in body) {
                Map[part.x, part.y] = part
            }

            return isAlive
        }

        fun grow() {

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
                Direction.UP -> body[0].x--
                Direction.LEFT -> body[0].y--
                Direction.DOWN -> body[0].x++
                Direction.RIGHT -> body[0].y++
            }
        }
    }
}