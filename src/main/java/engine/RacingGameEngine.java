package engine;

import console.InputView;
import console.OutputView;
import domain.Cars;
import utils.CarsFactory;

public class RacingGameEngine {

    public void startGame() {
        final String carNames = getCarNames();
        final int tryCount = getTryCount();

        Cars cars = CarsFactory.createCars(carNames);

        startRace(cars, tryCount);

        OutputView.printWinners(cars);
    }

    private String getCarNames() {
        OutputView.requestOfCarNames();
        return InputView.inputCarNames();
    }

    private int getTryCount() {
        OutputView.requestOfTryCount();
        return InputView.inputTryCount();
    }

    private void startRace(Cars cars, int tryCount) {
        OutputView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            OutputView.printCurrentRacingStatus(cars);
        }
    }
}
