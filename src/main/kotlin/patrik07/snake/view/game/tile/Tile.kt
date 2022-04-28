package patrik07.snake.view.game.tile

import javafx.scene.shape.Rectangle
import patrik07.snake.model.game.gameobjects.*
import patrik07.snake.view.game.tile.tiles.*

class Tile {
    companion object {
        const val size = 20.0
        private val tiles = hashMapOf<Any, TileFactory>(
            Food::class to FoodTileFactory(),
            GrassLight::class to GrassLightTileFactory(),
            GrassDark::class to GrassDarkTileFactory(),
            Wall::class to WallTileFactory(),
            Empty::class to EmptyTileFactory()
        )

        fun get(gameObject: GameObject): Rectangle {
            val tileFactory = tiles[gameObject::class]
            return tileFactory!!.getTile(gameObject)
        }
    }
}