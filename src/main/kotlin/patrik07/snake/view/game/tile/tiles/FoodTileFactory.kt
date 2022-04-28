package patrik07.snake.view.game.tile.tiles

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import patrik07.snake.model.game.gameobjects.GameObject

class FoodTileFactory : TileFactory() {
    override fun getTile(gameObject: GameObject): Rectangle {
        return Rectangle().apply {
            fill = Color.RED

            width = 20.0
            height = 20.0

            arcWidth = 10.0
            arcHeight = 10.0
        }
    }
}