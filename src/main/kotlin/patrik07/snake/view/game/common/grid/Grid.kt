package patrik07.snake.view.game.common.grid

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.layout.*
import javafx.scene.paint.Color
import patrik07.snake.view.game.common.tile.Tile

open class Grid(rowCount: Int, colCount: Int) : GridPane() {
    init {
        background = Background(BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY))

        alignment = Pos.CENTER

        prefWidth = rowCount * Tile.size
        prefHeight = colCount * Tile.size

        for (col in 0 until  colCount) {
            columnConstraints.add(ColumnConstraints().apply {
                halignment = HPos.CENTER
                prefWidth = Tile.size
            })
        }

        for (row in 0 until rowCount) {
            rowConstraints.add(RowConstraints().apply {
                valignment = VPos.CENTER
                prefHeight = Tile.size
            })
        }
    }

    operator fun get(row: Int, col: Int): Tile? {
        return children[row * Tile.size.toInt() + col] as Tile?
    }

    operator fun set(row: Int, col: Int, tile: Tile?) {
        add(tile, col, row)
    }
}