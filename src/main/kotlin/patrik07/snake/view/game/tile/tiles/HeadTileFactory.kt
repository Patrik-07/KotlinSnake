package patrik07.snake.view.game.tile.tiles

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import patrik07.snake.view.game.tile.TileFactory

class HeadTileFactory : TileFactory() {
    override fun getTile(): Rectangle {
        return Rectangle().apply {
            fill = Color.BLUE

            width = 10.0
            height = 10.0

            arcWidth = 8.0
            arcHeight = 8.0
        }
    }
}