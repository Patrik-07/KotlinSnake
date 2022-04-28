package patrik07.snake.view.game.tile.tiles

import javafx.scene.shape.Rectangle
import patrik07.snake.model.game.gameobjects.GameObject

abstract class TileFactory {
    abstract fun getTile(gameObject: GameObject): Rectangle
}