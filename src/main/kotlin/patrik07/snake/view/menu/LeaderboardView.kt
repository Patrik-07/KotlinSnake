package patrik07.snake.view.menu

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.SelectionMode
import javafx.scene.control.SelectionModel
import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import patrik07.snake.model.leaderboard.Leaderboard
import tornadofx.*

class LeaderboardView : View() {
    override val root = vbox(20) {
        style {
            backgroundColor.add(Color.DARKGRAY)
        }

        hbox {
            alignment = Pos.CENTER
            label("Best players") {
                font = Font.font(25.0)
                textFill = Color.WHITESMOKE
            }
        }

        val leaderboard = Leaderboard.instance
        listview<HBox> {
            isMouseTransparent = true
            style {
                backgroundColor.add(Color.LIGHTGRAY)
            }

            alignment = Pos.CENTER

            maxHeight = 200.0
            maxWidth = 150.0

            leaderboard.players.forEach {
                items.add(
                    hbox {
                        pane {
                            alignment = Pos.BASELINE_LEFT
                            prefWidth = 100.0
                            label(it.name) {
                                padding = Insets(0.0, 0.0, 0.0, 15.0)
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
}