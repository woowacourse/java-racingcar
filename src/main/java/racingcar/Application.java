package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Racing;

public class Application {

    public static void main(String[] args) {
        new RacingCarController(new Racing()).run();
    }
}
