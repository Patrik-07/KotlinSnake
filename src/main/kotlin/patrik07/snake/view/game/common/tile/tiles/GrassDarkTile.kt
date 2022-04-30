package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.view.game.common.tile.Tile

class GrassDarkTile : Tile() {
    init {
        fill = Color.color(0.635, 0.82, 0.286)
    }

    override fun create(): Tile {
        return GrassDarkTile()
    }
}