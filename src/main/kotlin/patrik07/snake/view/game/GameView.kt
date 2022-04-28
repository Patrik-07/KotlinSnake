package patrik07.snake.view.game

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.VPos
import javafx.scene.layout.*
import javafx.scene.paint.Color
import patrik07.snake.controller.game.GameController
import patrik07.snake.model.game.Map
import patrik07.snake.view.game.tile.Tile
import tornadofx.*


class GameView : View("\"Let'sss grow!\"") {
    private val controller: GameController by inject()

    override val root: GridPane
    private var grid : GridPane = gridpane {
        background = Background(BackgroundFill(Color.color(0.667, 0.843, 0.318), CornerRadii.EMPTY, Insets.EMPTY))

        val map = controller.getGameMap()
        val rowCount = map.rowCount
        val colCount = map.colCount

        prefWidth = rowCount * Tile.size
        prefHeight = colCount * Tile.size

        primaryStage.isResizable = false

        setOnKeyPressed {
            controller.handleKeyEvent(it)
        }
    }

    init {
        for (i in 1 .. 10)
        {
            grid.columnConstraints.add(ColumnConstraints().apply {
                halignment = HPos.CENTER
                prefWidth = 20.0
            })

            grid.rowConstraints.add(RowConstraints().apply {
                valignment = VPos.CENTER
                prefHeight = 20.0
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