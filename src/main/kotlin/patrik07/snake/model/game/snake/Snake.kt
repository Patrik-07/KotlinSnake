package patrik07.snake.model.game.snake

import patrik07.snake.model.game.Map
import patrik07.snake.model.game.gameobject.gameobjects.Head
import patrik07.snake.model.game.gameobject.gameobjects.Part

class Snake {
    companion object {
        private val body = ArrayList<Part>()

        var isAlive = true
        var direction: Int = Direction.RIGHT

        const val initialLength = 3
        val length get() = body.size

        fun reset() {
            isAlive = true
            direction = Direction.RIGHT

            Part.count = 0
            body.clear()
            val centerX = Map.rowCount / 2
            val centerY = Map.colCount / 2

            body.add(Head(centerX, centerY))
            for (i in 1 until initialLength)
                body.add(Part(centerX, centerY))
        }

        fun update() {
            move()
            if (isAlive) {
                Map.clearSnake()
                for (part in body) {
                    Map[part.x, part.y] = part
                }
            }
        }

        fun grow() {
            val lastPart = body.last()
            body.add(Part(lastPart.x, lastPart.y))

            Map.spawnFood()
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

            Map[body[0].x, body[0].y].collideWithSnake()
        }
    }
}