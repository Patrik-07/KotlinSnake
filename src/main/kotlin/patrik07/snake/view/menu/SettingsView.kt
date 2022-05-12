package patrik07.snake.view.menu

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import patrik07.snake.controller.controllers.MapController
import tornadofx.*

class SettingsView : View() {
    private val mapController: MapController by inject()

    override val root = vbox(20) {
        style {
            backgroundColor.add(Color.DARKGRAY)
        }

        hbox {
            padding = Insets(50.0, 0.0, 0.0, 0.0)
            alignment = Pos.CENTER
            label("Select a map!") {
                font = Font.font(25.0)
                textFill = Color.WHITESMOKE
            }
        }

        vbox {
            alignment = Pos.CENTER

            prefHeight = 100.0
            prefWidth = 150.0

            togglegroup {
                alignment = Pos.CENTER

                radiobutton {
                    isSelected = true
                    paddingAll = 5.0

                    label("Easy") {
                        prefWidth = 50.0
                    }

                    setOnAction {
                        mapController.setMapFromStringResources("maps/easy.txt")
                    }
                }
                radiobutton {
                    paddingAll = 5.0

                    label("Normal") {
                        prefWidth = 50.0
                    }

                    setOnAction {
                        mapController.setMapFromStringResources("maps/normal.txt")
                    }
                }
                radiobutton {
                    paddingAll = 5.0

                    label("Hard") {
                        prefWidth = 50.0
                    }

                    setOnAction {
                        mapController.setMapFromStringResources("maps/hard.txt")
                    }
                }
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
