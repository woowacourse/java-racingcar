package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.firstcollection.Cars;
import racingcar.model.vo.Car;
import racingcar.model.vo.MovableStrategy;
import racingcar.model.vo.RacingCarMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final MovableStrategy movableStrategy = new RacingCarMovableStrategy();

    public void start() {
        final Cars cars = setupCars();
        race(cars, InputView.getTrial());
        OutputView.printWinner(cars.getWinner());
    }

    private Cars setupCars() {
        return new Cars(getCarsFromUserInput());
    }

    private List<Car> getCarsFromUserInput() {
        return getCarsByCarNames(getCarNames());
    }

    private String[] getCarNames() {
        String userInput = InputView.getCarNames();

        return userInput.split(CAR_NAME_DELIMITER);
    }

    private List<Car> getCarsByCarNames(final String[] carNames) {
        return Arrays.stream(carNames)
                    .map(Car::new)
                    .collect(Collectors.toList());
    }

    private void race(final Cars cars, final int trials) {
        for (int round = 0; round < trials; round++) {
            cars.move(movableStrategy);
            OutputView.printCurrentPosition(cars.getCars());
        }
    }
}
