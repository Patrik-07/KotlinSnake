package patrik07.snake.view.game

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.layout.*
import javafx.scene.paint.Color
import patrik07.snake.controller.game.GameController
import patrik07.snake.model.game.Map
import patrik07.snake.view.game.tile.Tile
import tornadofx.*


class GameView : View("\"Let'sss grow!\"") {
    private val controller: GameController by inject()
    private var rowCount = 0
    private var colCount = 0

    override val root: GridPane
    private var grid : GridPane = gridpane {
        background = Background(BackgroundFill(Color.color(0.667, 0.843, 0.318), CornerRadii.EMPTY, Insets.EMPTY))

        alignment = Pos.CENTER

        val map = controller.getGameMap()
        rowCount = map.rowCount
        colCount = map.colCount

        prefWidth = rowCount * Tile.size
        prefHeight = colCount * Tile.size

        primaryStage.isResizable = false

        setOnKeyPressed {
            controller.handleKeyEvent(it)
        }
    }

    init {
        for (col in 0 until  colCount) {
            grid.columnConstraints.add(ColumnConstraints().apply {
                halignment = HPos.CENTER
                prefWidth = Tile.size
            })
        }

        for (row in 0 until rowCount) {
            grid.rowConstraints.add(RowConstraints().apply {
                valignment = VPos.CENTER
                prefHeight = Tile.size
            })
        }

        updateGrid(controller.getGameMap())
        root = grid
        val timeline = Timeline(
            KeyFrame(1.seconds, {
                updateGrid(controller.getGameMap())
            })
        )
        timeline.cycleCount = Animation.INDEFINITE
        timeline.play()
    }

    private fun updateGrid(gameMap: Map) {
        grid.clear()
        for (row in 0 until gameMap.rowCount) {
            for (col in 0 until gameMap.colCount) {
                val gameObject = gameMap.map[row][col]
                val tile = Tile.get(gameObject)
                grid.add(tile, col, row)
            }
        }
    }

    override fun onDock() {
        root.requestFocus()
    }
}