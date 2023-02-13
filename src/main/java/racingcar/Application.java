package racingcar;

import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingcarGame racingcarGame = new RacingcarGame(carNames, tryCount);
        racingcarGame.run();
    }
}
