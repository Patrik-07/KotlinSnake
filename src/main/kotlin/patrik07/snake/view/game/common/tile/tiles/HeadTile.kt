package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.view.game.common.tile.Tile

class HeadTile : Tile() {
    init {
        fill = Color.DARKBLUE

        arcWidth = 20.0
        arcHeight = 20.0
    }

    override fun create(gameObject: GameObject): Tile {
        return HeadTile()
    }
}