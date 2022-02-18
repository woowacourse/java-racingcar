package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private static RacingGame racingGame;
    private static Cars cars;

    public static void setRacingGame() {
        cars = new Cars(InputView.inputCarNames());
        racingGame = new RacingGame(cars, InputView.inputRounds());
    }

    public static void proceedRacingGame() {
        OutputView.printRaceResultMessage();
        while (!racingGame.isFinished()) {
            racingGame.run();
            updateViewOneTurnResult();
        }
    }

    public static void updateViewOneTurnResult() {
        OutputView.printOneTurnRaceResult(cars.getCarList());
    }

    public static void updateViewChampionNames() {
        OutputView.printChampionNames(racingGame.getChampionNames());
    }

    public static void main(String[] args) {
        setRacingGame();
        proceedRacingGame();
        updateViewChampionNames();
    }
}
