package patrik07.snake.view.game.tile

import javafx.scene.shape.Rectangle

abstract class TileFactory {
    abstract fun getTile(): Rectangle
}