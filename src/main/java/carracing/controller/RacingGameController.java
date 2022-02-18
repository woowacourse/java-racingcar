package carracing.controller;

import java.util.ArrayList;
import java.util.List;

import carracing.model.Car;
import carracing.model.RacingCars;
import carracing.view.InputView;
import carracing.view.OutputView;

public class RacingGameController {
    private RacingCars racingCars;
    private int numberOfGames;

    public RacingGameController() {
    }

    public void init() {
        getCars();
        getNumberOfGames();
    }

    public void play() {
        OutputView.printResultMessage();
        for (int round = 0; round < numberOfGames; round++) {
            racingCars.moveCars();
            OutputView.printGameResult(racingCars.getCars());
        }
        endGame();
    }

    private void getCars() {
        OutputView.printInputCarName();
        List<String> carNames = InputView.getCarNames();
        try {
            createCars(carNames);
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

    private void createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        racingCars = new RacingCars(carList);
    }
}
