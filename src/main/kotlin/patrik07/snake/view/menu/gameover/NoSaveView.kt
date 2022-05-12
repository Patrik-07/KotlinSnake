package patrik07.snake.view.menu.gameover

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class NoSaveView : GameOverView() {
    override val root = vbox(20) {
        label("Try again to get on the leaderboard!")

        hbox {
            alignment = Pos.CENTER
            padding = Insets(-15.0, 0.0, 0.0, 0.0)
            button("Ok") {
                setOnAction {
                    close()
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
        }
    }
}