package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final Cars cars;
    private final RacingGame racingGame;

    public RacingGameController(Cars cars, RacingGame racingGame) {
        this.cars = cars;
        this.racingGame = racingGame;
    }

    public void proceedRacingGame() {
        OutputView.printRaceResultMessage();

        while (!racingGame.isFinished()) {
            racingGame.run();
            updateViewOneTurnResult();
        }
    }

    public void updateViewOneTurnResult() {
        OutputView.printOneTurnRaceResult(cars.getCarList());
    }

    public void updateViewChampionNames() {
        OutputView.printChampionNames(racingGame.getChampionNames());
    }
}
