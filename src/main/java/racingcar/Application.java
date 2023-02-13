package racingcar;

import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String[] namesInput = InputView.carNames();
        int tryCount = InputView.tryCount();

        RacingcarController controller = new RacingcarController();
        controller.run(namesInput, tryCount);
    }
}
