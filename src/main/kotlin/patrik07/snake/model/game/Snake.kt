package patrik07.snake.model.game

class Snake(initialDirection: Int, length: Int) {
    companion object {
        val instance = Snake(Direction.RIGHT, 3)
    }

    private var body: MutableList<Part> = ArrayList()
    var direction: Int = initialDirection
        set(value) {
            body[0].direction = value
            field = value
        }

    init {
        for (i in 0 until length)
            body.add(Part(direction))
    }

    fun grow() {
        val lastPart = body.last()
        val dir = lastPart.direction

        body.add(Part(dir))
    }

    fun move() {
        body.forEach { 
            part ->
        }
    }
}