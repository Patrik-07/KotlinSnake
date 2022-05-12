package patrik07.snake.view.menu

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import patrik07.snake.controller.GameController
import tornadofx.*

class LeaderboardView : View() {
    private val gameController: GameController by inject()

    private val playersList = listview<HBox> {
        style {
            backgroundColor.add(Color.LIGHTGRAY)
        }

        isMouseTransparent = true

        maxHeight = 120.0
        maxWidth = 160.0

        items.clear()
        gameController.players.forEach {
            items.add(
                hbox {
                    pane {
                        alignment = Pos.BASELINE_LEFT
                        prefWidth = 110.0
                        label(it.name) {
                            padding = Insets(0.0, 0.0, 0.0, 10.0)
                        }
                    }
                    pane {
                        alignment = Pos.BASELINE_LEFT
                        label(it.score.toString())
                    }
                }
            )
        }
    }

    override val root = vbox(20) {
        alignment = Pos.CENTER

        style {
            backgroundColor.add(Color.DARKGRAY)
        }

        hbox {
            alignment = Pos.CENTER
            label("Best 5 players") {
                font = Font.font(25.0)
                textFill = Color.WHITESMOKE
            }
        }

        add(playersList)

        vbox(10) {
            alignment = Pos.BASELINE_CENTER

            button("Back") {
                vboxConstraints {
                    maxWidth = 110.0
                }
                setOnAction {
                    replaceWith(
                        MenuView::class,
                        transition = ViewTransition.Slide(0.5.seconds)
                    )
                }
                style {
                    backgroundColor.add(Color.GRAY)
                    backgroundRadius.add(box(10.px))
                }
                hoverProperty().onChange {
                    textFill = if (textFill == Color.WHITESMOKE) {
                        Color.BLACK
                    } else Color.WHITESMOKE
                }
            }
        }
    }

    override fun onDock() {
        super.onDock()
        resetPlayerList()
    }

    private fun resetPlayerList() {
        playersList.items.clear()
        val players = gameController.players

        for (i in 0 until players.size) {
            playersList.items.add(
                hbox {
                    pane {
                        alignment = Pos.BASELINE_LEFT
                        prefWidth = 110.0
                        label(players[i].name) {
                            padding = Insets(0.0, 0.0, 0.0, 10.0)
                        }
                    }
                    pane {
                        alignment = Pos.BASELINE_LEFT
                        label(players[i].score.toString())
                    }
                }
            )
        }
    }
}