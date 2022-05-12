package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.view.game.common.tile.Tile

class FoodTile : Tile()  {
    init {
        fill = Color.RED

        arcWidth = 20.0
        arcHeight = 20.0

        width = size - 3
        height = size - 3
    }

    override fun create(gameObject: GameObject): Tile {
        return FoodTile()
    }
}