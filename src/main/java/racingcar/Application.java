package racingcar;

import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.carNames();
        int tryCount = InputView.tryCount();

        RacingcarGame racingcarGame = new RacingcarGame(carNames, tryCount);
        racingcarGame.run();
    }
}
