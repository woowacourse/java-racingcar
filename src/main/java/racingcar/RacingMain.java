package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.exception.ExceptionHandler;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingMain {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.run();
    }
}
