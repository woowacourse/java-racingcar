package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        final CarRacing carRacing = new CarRacing(new InputView(), new OutputView());
        carRacing.start();
    }
}
