package patrik07.snake.view.menu

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*

class SaveView : View() {
    val name = SimpleStringProperty()

    override val root = vbox(20) {
        hbox {
            alignment = Pos.CENTER
            label("Save your points!") {
                padding = Insets(10.0, 0.0, 0.0, 0.0)
                font = Font.font(15.0)
            }
        }

        textfield(name) {
            promptText = "Name"
        }

        hbox {
            alignment = Pos.CENTER

            button("Save") {
                setOnAction {
                    if (!name.isBlank().get()) {
                        close()
                    }
                }
                hoverProperty().onChange {
                    if (!text.contains("~")) {
                        text = "~$text~"
                    } else {
                        text = text.removePrefix("~")
                        text = text.removeSuffix("~")
                    }
                }
            }
        }
    }
}