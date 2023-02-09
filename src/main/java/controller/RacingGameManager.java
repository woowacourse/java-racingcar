package controller;

import domain.RacingGame;
import domain.TryCount;
import utils.NormalRandomGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameManager {
    private RacingGameManager() {

    }

    public static void run() {
        List<String> carNames = InputView.readCarNames();
        TryCount tryCount = new TryCount(InputView.readCount());
        RacingGame racingGame = new RacingGame(carNames, tryCount);

        OutputView.printResultMessage();

        for (int i = 0; i < tryCount.getCount(); i++) {
            racingGame.moveCars(new NormalRandomGenerator());
            OutputView.printAllCars(racingGame.getCars());
        }

        OutputView.printAllCars(racingGame.getCars());
        OutputView.printWinners(racingGame.decideWinners());
    }

}
