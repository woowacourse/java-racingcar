package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.RandomNumberOverThanFour;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController =
                new RacingController(new ConsoleInputView(), new ConsoleOutputView(),
                        new RandomNumberOverThanFour(new RandomNumberGenerator()));
        racingController.run();
    }
}
