package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        new RacingCarController(new InputView()).run();
    }
}
