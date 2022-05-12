package patrik07.snake.view.menu.gameover

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.paint.Color
import patrik07.snake.controller.GameController
import patrik07.snake.model.leaderboard.Player
import tornadofx.*

class SaveView : GameOverView() {
    private val gameController: GameController by inject()

    private var name = SimpleStringProperty()
    private val textField = textfield(name) {
        textProperty().onChange {
            if (text.length > 8) {
                val s: String = text.substring(0, 8)
                text = s
            }
        }
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
        hbox {
            alignment = Pos.CENTER
            padding = Insets(0.0, 0.0, -15.0, 0.0)

            label("Save your score!")
        }

        add(textField)

        hbox {
            alignment = Pos.CENTER
            padding = Insets(-15.0, 0.0, 0.0, 0.0)
            button("Save") {
                setOnAction {
                    if (name.isBlank().get()) {
                        textField.style {
                            backgroundColor.add(Color.INDIANRED)
                        }
                    } else {
                        val player = Player(name.get(), gameController.getScore())
                        gameController.addPlayerToLeaderboard(player)
                        close()
                    }
                    textField.clear()
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