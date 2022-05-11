package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.view.game.common.tile.Tile

class EmptyTile : Tile()  {
    init {
        fill = Color.TRANSPARENT
    }

    override fun create(gameObject: GameObject): Tile {
        return EmptyTile()
    }
}