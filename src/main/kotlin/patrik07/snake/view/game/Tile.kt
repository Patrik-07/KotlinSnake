package patrik07.snake.view.game

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import patrik07.snake.model.game.gameobjects.*

class Tile {
    companion object {
        private val tiles = hashMapOf<Any, Color>(
            Wall::class to Color.BROWN,

            Grass1::class to Color.color(0.635, 0.82, 0.286),
            Grass2::class to Color.color(0.667, 0.843, 0.318),

            //Head::class to Color.BLUE,
            Part::class to Color.DARKGREY,

            Food::class to Color.RED
        )
        private var size = 30.0

        fun get(gameObject: GameObject): Rectangle {
            val rectangle = Rectangle(gameObject.x.toDouble() * size, gameObject.y.toDouble() * size, size, size)
            rectangle.fill = tiles[gameObject::class]

            if (gameObject is Grass1) {
                rectangle.x += 2
                rectangle.y += 2

                rectangle.width -= 2
                rectangle.height -=2
            }

            return rectangle
        }
    }
}