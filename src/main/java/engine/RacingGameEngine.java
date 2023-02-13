package engine;

import console.InputView;
import console.OutputView;
import domain.Car;
import domain.Cars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGameEngine {

    private static final String SPLIT_DELIMITER = ",";

    public void gameStart() {

        final String carName = getCarName();
        final int tryCount = getTryCount();

        Cars cars = makeCars(carName);

        startRace(cars, tryCount);

        OutputView.printWinner(cars);
    }

    private String getCarName() {
        OutputView.requestOfCarNames();
        return InputView.inputCarName();
    }

    private int getTryCount() {
        OutputView.requestOfTryCount();
        return InputView.inputTryCount();
    }

    private Cars makeCars(String carName) {
        String[] splitCarName = carName.split(SPLIT_DELIMITER);

        Cars cars = new Cars(Arrays.stream(splitCarName)
                                   .map(Car::new)
                                   .collect(Collectors.toList()));
        return cars;
    }

    private void startRace(Cars cars, int tryCount) {

        OutputView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            CarEngine.moveCar(cars);
            OutputView.printCurrentStatus(cars);
        }
    }
}
