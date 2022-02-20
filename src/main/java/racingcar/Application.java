package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.random.RacingcarRandomNumberGenerator;
import racingcar.view.input.NamesInput;
import racingcar.view.input.TryCountInput;

public class Application {

    public static void main(String[] args) {
        new Controller(
                new NamesInput().receive(),
                new TryCountInput().receive(),
                new RacingcarRandomNumberGenerator()
        ).runGame();
    }
}
