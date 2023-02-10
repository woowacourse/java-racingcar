package engine;

import console.InputView;
import console.OutputView;
import domain.Car;
import domain.Cars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGameEngine {
    public void startGame() {
        final String carsName = getCarsName();
        final int tryCount = getTryCount();

        Cars cars = new Cars(carsName);

        startRace(cars, tryCount);

        OutputView.printWinners(cars);
    }

    private String getCarsName() {
        OutputView.requestOfCarNames();
        return InputView.inputCarsName();
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
