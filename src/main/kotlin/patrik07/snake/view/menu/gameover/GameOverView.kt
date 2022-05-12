package patrik07.snake.view.menu.gameover

import tornadofx.*

abstract class GameOverView : View("Game is Over!") {
    companion object {
        var isClosed = true
        var isOpened = false
    }

    override fun onUndock() {
        super.onUndock()
        isClosed = true
    }

    override fun onDock() {
        super.onDock()
        isOpened = true
        isClosed = false
    }
}