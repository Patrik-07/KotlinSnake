package patrik07.snake.view.menu

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import patrik07.snake.model.game.gameobjects.Empty
import sun.java2d.pipe.SpanShapeRenderer.Simple
import tornadofx.*

class SaveView : View("Save your points!") {
    private var name = SimpleStringProperty()
    private val textField =  textfield(name) {
        promptText = "Name"
        style {
            backgroundColor.add(Color.WHITE)
        }
        focusedProperty().onChange {
            style {
                backgroundColor.add(Color.WHITE)
            }
        }
    }

    override val root = vbox(20) {
        add(textField)

        hbox {
            alignment = Pos.CENTER
            padding = Insets(-15.0, 0.0, 0.0, 0.0)
            button("Save") {
                setOnAction {
                    if (name.isEmpty.get()) {
                        timeline {
                            keyframe(1.seconds) {
                                textField.style {
                                    backgroundColor.add(Color.INDIANRED)
                                }
                            }
                        }
                    } else {
                        textField.clear()
                        close()
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
        }
    }

    override fun onDock() {
        super.onDock()
        textField.clear()
    }
}