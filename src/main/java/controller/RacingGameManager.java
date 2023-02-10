package controller;

import domain.Name;
import domain.RacingGame;
import domain.TryCount;
import utils.NormalRandomGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameManager {
    private RacingGame racingGame;

    public void run() {
        List<Name> carNames = readCarNames();
        TryCount tryCount = readTryCount();
        racingGame = new RacingGame(carNames);

        startRace(tryCount);

        OutputView.printAllCars(racingGame.getCars());
        OutputView.printWinners(racingGame.decideWinners());
    }

    private void startRace(TryCount tryCount) {
        OutputView.printResultMessage();

        while (tryCount.canTry()) {
            racingGame.moveCars(new NormalRandomGenerator());
            OutputView.printAllCars(racingGame.getCars());
            tryCount.decreaseCount();
        }
    }

    private TryCount readTryCount() {
        try {
            return new TryCount(InputView.readCount());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return readTryCount();
        }
    }

    public List<Name> readCarNames() {
        try {
            return InputView.readCarNames()
                    .stream()
                    .map(Name::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }
}
