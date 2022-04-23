package patrik07.snake.view

import javafx.geometry.Pos
import javafx.scene.layout.HBox
import javafx.scene.text.Font
import patrik07.snake.model.leaderboard.Leaderboard
import tornadofx.*

class LeaderboardView : View() {
    override val root = vbox(20) {
        hbox {
            alignment = Pos.CENTER
            label("Best players") {
                font = Font.font(20.0)
            }
        }

        val leaderboard = Leaderboard.instance
        listview<HBox> {
            alignment = Pos.CENTER

            maxHeight = 200.0
            maxWidth = 150.0

            leaderboard.players.forEach {
                items.add(
                    hbox {
                        alignment = Pos.CENTER
                        label(it.toString())
                    }
                )
            }
        }

        vbox(10) {
            alignment = Pos.BASELINE_CENTER

            button("Back") {
                vboxConstraints {
                    maxWidth = 100.0
                }
                setOnAction {
                    replaceWith<MenuView>()
                }
            }
        }
    }
}