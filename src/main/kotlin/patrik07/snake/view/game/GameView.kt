package patrik07.snake.view.game

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.geometry.Pos
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.scene.paint.Color
import javafx.scene.text.Font
import patrik07.snake.controller.game.GameController
import patrik07.snake.view.game.map.BackgroundView
import patrik07.snake.view.game.map.MapView
import patrik07.snake.view.menu.SaveView
import tornadofx.*

class GameView : View() {
    private val gameController: GameController by inject()

    private val backgroundView = BackgroundView()
    private val mapView = MapView()
    private val scoreLabel = Label().apply {
        font = Font.font(15.0)
    }

    private var isGameOver = false
    private val timeline = Timeline(
        KeyFrame(0.5.seconds, {
            isGameOver = gameController.updateGame()
            if (!isGameOver) {
                mapView.update()
                setScore()
            } else {
                if (!SaveView.isOpened) {
                    openInternalWindow(SaveView::class)
                }
                if (SaveView.isClosed) {
                    SaveView.isOpened = false
                    SaveView.isClosed = false
                    gameController.resetGame()
                    close()
                }
            }
        })
    )

    override val root = pane {
        style {
            backgroundColor.add(Color.DARKGRAY)
        }

        vbox {
            hbox {
                paddingAll = 5.0
                alignment = Pos.CENTER
                pane {
                    add(backgroundView)
                    add(mapView)
                }
            }
            hbox {
                paddingAll = 5.0
                alignment = Pos.CENTER
                add(scoreLabel)
            }
        }

        setOnKeyPressed {
            gameController.handleKeyEvent(it)
        }
    }

    override fun onUndock() {
        super.onUndock()
        SaveView.isClosed = true
        timeline.stop()
    }

    override fun onDock() {
        super.onDock()
        initView()
    }

    private fun initView() {
        gameController.resetGame()

        setScore()
        setOnClose()

        timeline.cycleCount = Animation.INDEFINITE
        timeline.playFromStart()

        root.requestFocus()
    }

    private fun setScore() {
        val score = gameController.getScore()
        val text = "SCORE: $score"
        scoreLabel.text = text
    }

    private fun setOnClose() {
        currentWindow?.setOnCloseRequest { it ->
            timeline.stop()
            it.consume()
            alert(
                Alert.AlertType.NONE,
                "Are you sure you want to leave?",
                "Your score will be lost.",
                ButtonType.YES,
                ButtonType.NO
            ) {
                if (it.text == "Yes") {
                    gameController.resetGame()
                    val v = find<SaveView>()
                    if (v.isDocked)
                        v.close()
                    SaveView.isOpened = false
                    timeline.stop()
                    currentWindow?.hide()
                } else timeline.play()
            }
        }
    }
}