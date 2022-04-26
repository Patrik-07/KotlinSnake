package patrik07.snake.view.main

import javafx.animation.Timeline
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import patrik07.snake.controller.GameController
import patrik07.snake.model.game.Game
import patrik07.snake.model.game.GameMap
import patrik07.snake.view.game.Tile
import tornadofx.*

class GameView : View() {
    private val controller: GameController by inject()
    val game = Game.instance

    private val gameMap = GameMap(20)

    var asd = 0

    override val root = vbox(20) {
        prefHeight = 600.0
        resize(600.0, 600.0)

        setOnKeyPressed {
            controller.handleKeyEvent(it)
        }

        hbox {
            alignment = Pos.CENTER
            label("Let's grooow!") {
                font = Font.font(20.0)
            }
        }

        timeline {
            keyframe(1.seconds) {
                game.update()
                pane {
                    for (i in 0 until 20) {
                        for (j in 0 until 20) {
                            rectangle(i * 10, j * 10, 10, 10) {
//                                fill = Tile.getColor(gameMap.map[i][j])
                            }
                        }
                    }
                    alignment = Pos.CENTER
                }
            }
            cycleCount = Timeline.INDEFINITE
        }

        vbox(10) {
            alignment = Pos.CENTER

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