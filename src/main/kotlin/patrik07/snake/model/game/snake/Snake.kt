package patrik07.snake.model.game.snake

import patrik07.snake.model.game.gameobjects.Head

class Snake(initialDirection: Int, length: Int) {
    var isAlive = true
    var body: MutableList<Head> = ArrayList()

    var direction: Int = initialDirection
        set(value) {
            //body[0].direction = value
            field = value
            "############" +
            "#GGGGGGGGGG#" +
            "#"
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