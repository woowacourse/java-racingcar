package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RandomNumberOverThanFour;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController =
                new RacingController(new ConsoleInputView(), new ConsoleOutputView(), new RandomNumberOverThanFour());
        racingController.run();
    }
}
