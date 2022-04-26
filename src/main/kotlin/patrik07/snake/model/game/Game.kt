package patrik07.snake.model.game

class Game {
    companion object {
        val instance = Game()
    }

    val snake = Snake.instance
    val map = GameMap(20).map

    fun start() {

    }

    fun over() {
        //gv.numbers += 5

        // find(GameView::class).replaceWith(MenuView::class)
    }

    fun update() {


    }
}