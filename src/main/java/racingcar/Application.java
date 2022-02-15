package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.random.RacingcarRandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new RacingcarRandomNumberGenerator());
        controller.runGame();
    }
}
