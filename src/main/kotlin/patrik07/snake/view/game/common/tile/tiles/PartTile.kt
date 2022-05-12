package patrik07.snake.view.game.common.tile.tiles

import javafx.scene.paint.Color
import patrik07.snake.model.game.gameobject.GameObject
import patrik07.snake.model.game.gameobject.gameobjects.Part
import patrik07.snake.view.game.common.tile.Tile

class PartTile : Tile() {
    companion object {
        var index = 1
    }

    init {
        fill = Color.BLUE

        arcWidth = 20.0
        arcHeight = 20.0

        val decreasePercent = 0.04
        val maximumDecrease = 0.75

        var p = maximumDecrease

        val currentDecreasePercent = 1 - (index * decreasePercent)
        if (currentDecreasePercent > maximumDecrease) {
            p = currentDecreasePercent
        }

        width = size * p - 5
        height = size * p - 5
    }

    override fun create(gameObject: GameObject): Tile {
        val part = gameObject as Part
        index = part.index

        return PartTile()
    }
}