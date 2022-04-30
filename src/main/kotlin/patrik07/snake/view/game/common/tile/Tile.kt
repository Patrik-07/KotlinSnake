package patrik07.snake.view.game.common.tile

import javafx.scene.shape.Rectangle
import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.gameobject.gameobjects.*
import patrik07.snake.view.game.common.tile.tiles.*

abstract class Tile : Rectangle() {
    init {
        width = size
        height = size
    }

    abstract fun create(): Tile

    companion object {
        const val size = 20.0
        private val tiles = hashMapOf<Any, Tile>(
            Empty::class to EmptyTile(),
            Wall::class to WallTile(),

            Food::class to FoodTile(),

            Head::class to HeadTile(),
            Pair::class to PartTile()
        )

        fun get(gameObject: GameObject): Tile? {
            return tiles[gameObject::class]
        }
    }
}