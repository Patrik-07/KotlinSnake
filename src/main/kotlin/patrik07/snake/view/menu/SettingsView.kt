package patrik07.snake.view.menu

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.text.Font
import patrik07.snake.controller.game.MapController
import tornadofx.*

class SettingsView : View() {
    private val mapController: MapController by inject()

    override val root = vbox(20) {
        hbox {
            padding = Insets(50.0, 0.0, 0.0, 0.0)
            alignment = Pos.CENTER
            label("Select map!") {
                font = Font.font(20.0)
            }
        }

        vbox {
            alignment = Pos.CENTER

            prefHeight = 100.0
            prefWidth = 150.0

            togglegroup {
                alignment = Pos.CENTER

                radiobutton("Map01") {
                    isSelected = true
                    setOnAction {
                        mapController.setMapFromStringResources("maps/easy.txt")
                    }
                    paddingAll = 5.0
                }
                radiobutton("Map02") {
                    setOnAction {
                        mapController.setMapFromStringResources("maps/normal.txt")
                    }
                    paddingAll = 5.0
                }
                radiobutton("Map03") {
                    setOnAction {
                        mapController.setMapFromStringResources("maps/hard.txt")
                    }
                    paddingAll = 5.0
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
                    replaceWith(
                        MenuView::class,
                        transition = ViewTransition.Metro(1.seconds)
                    )
                }
            }
        }
    }
}
