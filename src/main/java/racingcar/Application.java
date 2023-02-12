package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.startRacing();
        String namesInput = InputView.carNames();
        OutputView.tryCount();
        int tryCount = InputView.tryCount();

        RacingcarController controller = new RacingcarController();
        controller.run(namesInput, tryCount);
    }
}
