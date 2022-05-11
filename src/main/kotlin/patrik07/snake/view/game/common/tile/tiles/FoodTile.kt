package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.view.game.common.tile.Tile

class FoodTile : Tile()  {
    init {
        fill = Color.RED

        arcWidth = 10.0
        arcHeight = 10.0
    }

    override fun create(gameObject: GameObject): Tile {
        return FoodTile()
    }
}