package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.view.game.common.tile.Tile

class GrassLightTile : Tile() {
    init {
        fill = Color.color(0.667, 0.843, 0.318)
    }

    override fun create(): Tile {
        return GrassLightTile()
    }
}