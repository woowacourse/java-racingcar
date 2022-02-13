package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RandomNumberOverThanFour;

import racingcar.view.InputView.ConsoleInputView;
import racingcar.view.OutputView.ConsoleOutputView;


public class Application {
    public static void main(String[] args) {
        RacingController racingController =
                new RacingController(new ConsoleInputView(), new ConsoleOutputView(), new RandomNumberOverThanFour());
        racingController.run();
    }
}
