package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.view.game.common.tile.Tile

class WallTile : Tile() {
    init {
        fill = Color.color(0.3, 0.2, 0.2)

        arcWidth = 8.0
        arcHeight = 8.0
    }

    override fun create(gameObject: GameObject): Tile {
        return WallTile()
    }
}