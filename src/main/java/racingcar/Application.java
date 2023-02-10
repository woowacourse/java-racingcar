package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.startRacing();
        String namesInput = InputView.carNames();

        RacingcarController controller = new RacingcarController(namesInput);

        OutputView.tryCount();
        int tryCount = InputView.tryCount();

        controller.run(tryCount);
    }
}
