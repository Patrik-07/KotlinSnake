package patrik07.snake.view

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*

class GameView : View() {
    override val root = vbox(20) {
        prefHeight = 600.0
        resize(600.0, 600.0)

        hbox {
            alignment = Pos.CENTER
            label("Let's grooow!") {
                font = Font.font(20.0)
            }
        }

        val numbers = (1..10).toList()

        datagrid(numbers) {
            alignment = Pos.CENTER

            maxWidth = 400.0
            maxHeight = 300.0

            cellHeight = 75.0
            cellWidth = 75.0

            multiSelect = true

            cellCache {
                stackpane {
                    circle(radius = 25.0) {
                        fill = Color.FORESTGREEN
                    }
                    label(it.toString())
                }
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