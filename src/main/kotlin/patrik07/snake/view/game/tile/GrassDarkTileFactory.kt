package patrik07.snake.view.game.tile

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class GrassDarkTileFactory : TileFactory() {
    override fun getTile(): Rectangle {
        return Rectangle().apply {
            fill = Color.color(0.635, 0.82, 0.286)

            width = 20.0
            height = 20.0
        }
    }
}