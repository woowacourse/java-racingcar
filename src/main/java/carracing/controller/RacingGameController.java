package carracing.controller;

import carracing.model.Car;
import java.util.List;

import carracing.model.RacingCars;
import carracing.view.InputView;
import carracing.view.OutputView;

public class RacingGameController {
    private RacingCars racingCars;
    private int numberOfGames;

    public void init() {
        getCars();
        getNumberOfGames();
    }

    public void play() {
        OutputView.printResultMessage();
        for (int round = 0; round < numberOfGames; round++) {
            racingCars.moveCars();
            OutputView.printGameResult(racingCars.getCarsStatus());
        }
        endGame();
    }

    private void getCars() {
        OutputView.printInputCarName();
        List<String> carNames = InputView.getCarNames();
        try {
            this.racingCars = new RacingCars(Car.getCars(carNames));
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            getCars();
        }
    }

    private void getNumberOfGames() {
        OutputView.printInputNumberOfGames();
        try {
            numberOfGames = InputView.getNumberOfGames();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            getNumberOfGames();
        }
    }

    private void endGame() {
        OutputView.printWinners(racingCars.getWinners());
    }
}
