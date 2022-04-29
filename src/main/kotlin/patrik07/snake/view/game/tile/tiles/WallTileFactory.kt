package patrik07.snake.view.game.tile.tiles

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import patrik07.snake.view.game.tile.TileFactory

class WallTileFactory : TileFactory() {
    override fun getTile(): Rectangle {
        return Rectangle().apply {
            fill = Color.color(0.3, 0.2, 0.2)

            width = 20.0
            height = 20.0

            arcWidth = 8.0
            arcHeight = 8.0
        }
    }
}