package patrik07.snake.view.game.tile

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class GrassLightTileFactory : TileFactory() {
    override fun getTile(): Rectangle {
        return Rectangle().apply {
            fill = Color.color(0.667, 0.843, 0.318)

            width = 20.0
            height = 20.0
        }
    }
}