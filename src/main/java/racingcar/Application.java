package racingcar;

import racingcar.config.AppConfig;
import racingcar.domain.Game;

public class Application {

    public static void main(String[] args) {
        Game game = AppConfig.getGame();
        game.play(AppConfig.getRule());
    }
}
