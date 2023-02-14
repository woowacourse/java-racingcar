package controller;

import domain.Name;
import domain.RacingGame;
import domain.TryCount;
import utils.Engine;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameManager {
    private final Engine engine;
    private RacingGame racingGame;

    public RacingGameManager(Engine engine){
        this.engine = engine;
    }

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

        for (int i = 0; i < tryCount.getCount(); i++) {
            racingGame.moveCars(engine);
            OutputView.printAllCars(racingGame.getCars());
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

    private List<Name> readCarNames() {
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
