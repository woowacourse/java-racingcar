package racingcar;

import racingcar.domain.Game;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}