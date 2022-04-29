package patrik07.snake.view.game.grid

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.layout.*
import javafx.scene.paint.Color
import patrik07.snake.model.game.Map
import patrik07.snake.view.game.tile.Tile
import tornadofx.FX.Companion.primaryStage

class MapGrid(map: Map) : GridPane() {
    private val rowCount = map.rowCount
    private val colCount = map.colCount

    init {
        background = Background(BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY))

        alignment = Pos.CENTER

        prefWidth = rowCount * Tile.size
        prefHeight = colCount * Tile.size

        primaryStage.isResizable = false

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

    fun update(map: Map) {
        for (row in 0 until rowCount) {
            for (col in 0 until colCount) {
                val gameObject = map[row, col]
                val tile = Tile.get(gameObject)
                add(tile, col, row)
            }
        }
    }
}