package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.view.game.common.tile.Tile

class HeadTile : Tile() {
    init {
        fill = Color.BLUE

        arcWidth = 8.0
        arcHeight = 8.0
    }

    override fun create(): Tile {
        return HeadTile()
    }
}