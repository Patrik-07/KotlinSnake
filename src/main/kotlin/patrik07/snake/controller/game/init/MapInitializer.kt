package patrik07.snake.controller.game.init

import patrik07.snake.model.game.settings.properties.SnakeProperty
import patrik07.snake.model.game.snake.Snake

class MapInitializer {
    fun init(snakeProperty: SnakeProperty): Snake {
        return Snake()
    }
}