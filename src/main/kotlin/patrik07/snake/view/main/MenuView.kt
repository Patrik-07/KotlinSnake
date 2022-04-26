package patrik07.snake.view.main

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.text.Font
import patrik07.snake.view.game.GameView
import patrik07.snake.view.game.SaveView
import tornadofx.*

class MenuView : View() {
    override val root = vbox(20) {
        prefWidth = 400.0
        prefHeight = 350.0

        hbox {
            alignment = Pos.CENTER
            label("Snake game") {
                padding = Insets(20.0, 0.0, 0.0, 0.0)
                font = Font.font(20.0)
            }
        }

        vbox(10) {
            alignment = Pos.BASELINE_CENTER

            button("Play") {
                vboxConstraints {
                    maxWidth = 100.0
                }
                setOnAction {
                    val w = find<GameView>().openModal()
                    w?.isResizable = false
                    w?.setOnCloseRequest {
                        openInternalWindow<SaveView>()
                    }
                }
            }
            button("Leaderboard") {
                vboxConstraints {
                    maxWidth = 100.0
                }
                setOnAction {
                    replaceWith(
                        LeaderboardView::class,
                        transition = ViewTransition.Metro(1.seconds)
                    )
                }
            }
            button("Quit") {
                vboxConstraints {
                    maxWidth = 100.0
                }
                setOnAction {
                    close()
                }
            }
        }
    }
}