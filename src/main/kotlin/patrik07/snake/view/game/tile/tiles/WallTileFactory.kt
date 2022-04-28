package patrik07.snake.view.game.tile.tiles

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import patrik07.snake.model.game.gameobjects.GameObject
import tornadofx.*

class WallTileFactory : TileFactory() {
    override fun getTile(gameObject: GameObject): Rectangle {
        return Rectangle().apply {
            fill = Color.color(0.3, 0.2, 0.2)

            width = 10.0
            height = 10.0

            arcWidth = 8.0
            arcHeight = 8.0
        }
    }
}