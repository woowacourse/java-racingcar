package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.random.RacingcarRandomNumberGenerator;
import racingcar.input.NamesReceiver;
import racingcar.input.TryCountReceiver;

public class Application {

    public static void main(String[] args) {
        new Controller(
                new NamesReceiver().receive(),
                new TryCountReceiver().receive(),
                new RacingcarRandomNumberGenerator()
        ).runGame();
    }
}
