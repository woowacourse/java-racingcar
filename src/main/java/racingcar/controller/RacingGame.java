package racingcar.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import racingcar.model.firstcollection.Cars;
import racingcar.model.vo.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public static final String CAR_NAME_DELIMITER = ",";

    public void start() {
        Cars cars = setupCars();
        race(cars, InputView.getTrial());
        OutputView.printWinner(cars.getWinner());
    }

    private Cars setupCars() {
        return new Cars(Arrays.stream(InputView.getCarNames()
                            .split(CAR_NAME_DELIMITER))
                            .map(Car::new)
                            .collect(Collectors.toList()));
    }

    private void race(Cars cars, int trials) {
        for (int round = 0; round < trials; round++) {
            cars.move();
            OutputView.printCurrentPosition(cars.getCars());
        }
    }
}
