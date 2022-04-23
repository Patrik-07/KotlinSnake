package patrik07.snake.view

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.text.Font
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

            button("Start") {
                vboxConstraints {
                    maxWidth = 100.0
                }
                setOnAction {
                    replaceWith<GameView>()
                }
            }
            button("Leaderboard") {
                vboxConstraints {
                    maxWidth = 100.0
                }
                setOnAction {
                    replaceWith<LeaderboardView>()
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