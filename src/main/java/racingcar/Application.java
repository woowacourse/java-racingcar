package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.movement.RandomNumberOverThanFour;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController =
                new RacingController(new ConsoleInputView(), new ConsoleOutputView(),
                        new RandomNumberOverThanFour());
        racingController.run();
    }
}
