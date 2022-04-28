package patrik07.snake.view.game.tile.tiles

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import patrik07.snake.model.game.gameobjects.GameObject

class GrassDarkTileFactory : TileFactory() {
    override fun getTile(gameObject: GameObject): Rectangle {
        return Rectangle().apply {
            fill = Color.color(0.635, 0.82, 0.286)

            width = 20.0
            height = 20.0
        }
    }
}