package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.firstcollection.Cars;
import racingcar.domain.strategy.MovableStrategy;
import racingcar.domain.strategy.RacingCarMovableStrategy;
import racingcar.domain.vo.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final MovableStrategy movableStrategy = new RacingCarMovableStrategy();

    public void start() {
        final Cars cars = setupCars();
        race(cars, InputView.getTrial());
        OutputView.printWinner(cars.getWinnerNames());
    }

    private Cars setupCars() {
        return new Cars(getCarsFromUserInput());
    }

    private List<Car> getCarsFromUserInput() {
        return getCarsByCarNames(getCarNames());
    }

    private List<String> getCarNames() {
        String userInput = InputView.getCarNames();
        String[] splitNames = userInput.split(CAR_NAME_DELIMITER);

        return Arrays.stream(splitNames)
                .collect(Collectors.toList());
    }

    private List<Car> getCarsByCarNames(final List<String> carNames) {
        return carNames.stream()
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
