package controller;

import domain.RacingGame;
import utils.NormalRandomGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameManager {
    private RacingGameManager() {

    }

    public static void run() {
        List<String> carNames = InputView.readCarNames();
        int count = InputView.readCount();
        RacingGame racingGame = new RacingGame(carNames, count);

        OutputView.printResultMessage();

        for (int i = 0; i < count; i++) {
            racingGame.moveCars(new NormalRandomGenerator());
            OutputView.printState(racingGame.getCars());
        }

        OutputView.printState(racingGame.getCars());
        OutputView.printWinners(racingGame.decideWinners());
    }

}
