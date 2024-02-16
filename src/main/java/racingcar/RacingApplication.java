package racingcar;

import racingcar.io.InputView;
import racingcar.io.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(new InputView(), new OutputView());
        carRacing.start();
    }
}
