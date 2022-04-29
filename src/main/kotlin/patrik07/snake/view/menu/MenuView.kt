package patrik07.snake.view.menu

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import patrik07.snake.view.game.GameView
import tornadofx.*

class MenuView : View() {
    override val root = vbox(20) {
        prefWidth = 400.0
        prefHeight = 350.0

        primaryStage.isResizable = false

        style {
            backgroundColor.add(Color.DARKGRAY)
        }

        hbox {
            alignment = Pos.CENTER
            label("Snake game") {
                padding = Insets(20.0, 0.0, 0.0, 0.0)
                font = Font.font(30.0)
                textFill = Color.WHITESMOKE
            }
        }

        vbox(10) {
            alignment = Pos.BASELINE_CENTER

            button("Play") {
                vboxConstraints {
                    maxWidth = 110.0
                }
                setOnAction {
                    val w = find<GameView>().openModal()
                    w?.isResizable = false
                    w?.setOnCloseRequest {
                        openInternalWindow(SaveView::class)
                    }
                }
                hoverProperty().onChange {
                    textFill = if (textFill == Color.WHITESMOKE) {
                        Color.BLACK
                    } else Color.WHITESMOKE
                }
                style {
                    backgroundColor.add(Color.GRAY)
                    backgroundRadius.add(box(10.px))
                }
            }

            button("Leaderboard") {
                vboxConstraints {
                    maxWidth = 110.0
                    margin = Insets(20.0, 0.0, 0.0, 0.0)
                }
                setOnAction {
                    replaceWith(
                        LeaderboardView::class,
                        transition = ViewTransition.Slide(0.5.seconds)
                    )
                }
                hoverProperty().onChange {
                    textFill = if (textFill == Color.WHITESMOKE) {
                        Color.BLACK
                    } else Color.WHITESMOKE
                }
                style {
                    backgroundColor.add(Color.GRAY)
                    backgroundRadius.add(box(10.px))
                }
            }

            button("Settings") {
                vboxConstraints {
                    maxWidth = 110.0
                }
                setOnAction {
                    replaceWith(
                        SettingsView::class,
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

            button("Quit") {
                vboxConstraints {
                    maxWidth = 110.0
                    margin = Insets(0.0, 0.0, 20.0, 0.0)
                }
                setOnAction {
                    close()
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