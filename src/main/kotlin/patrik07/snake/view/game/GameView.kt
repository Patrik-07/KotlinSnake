package patrik07.snake.view.game

import patrik07.snake.model.game.Game
import tornadofx.*

class GameView : View() {
    private val game = Game()

    override val root = pane {
        for (row in game.map) {
            for (tile in row) {
                add(Tile.get(tile))
//                rectangle(tile.x * tileSize, tile.y * tileSize, tileSize, tileSize) {
//                    fill = Tile.getColor(tile)
//                }
            }
        }
    }
}