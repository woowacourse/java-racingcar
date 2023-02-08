package domain;

import view.InputView;

import java.util.List;

public class RacingGameManager {
    private RacingGameManager() {

    }

    public static void run() {
        List<String> carNames = InputView.readCarNames();
        int count = InputView.readCount();
        RacingGame racingGame = new RacingGame(carNames, count);
        racingGame.start();
    }
}
