package patrik07.snake.view.game.tile.tiles

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import patrik07.snake.view.game.tile.TileFactory

class EmptyTileFactory : TileFactory() {
    override fun getTile(): Rectangle {
        return Rectangle().apply {
            fill = Color.WHITESMOKE

            width = 20.0
            height = 20.0
        }
    }
}