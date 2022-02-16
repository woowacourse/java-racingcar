package racingcar.controller;

import java.util.Arrays;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.trycount.TryCount;
import racingcar.util.MovableStrategy;
import racingcar.util.RacingCarMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final Cars cars = Cars.create();
    private final MovableStrategy racingCarMovableStrategy = new RacingCarMovableStrategy();
    private TryCount tryCount;

    public RaceController() {
    }

    public void setUpCars() {
        try {
            String input = InputView.inputNames();
            Arrays.stream(input.split(","))
                .map(Car::from)
                .forEach(cars::add);
            cars.validateIsEmpty();
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            setUpCars();
        }
    }

    public void setUpTryCount() {
        try {
            String input = InputView.inputTryCount();
            tryCount = TryCount.from(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            setUpTryCount();
        }
    }

    public void raceStart() {
        OutputView.printRaceResult();
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.race(racingCarMovableStrategy);
            OutputView.printCars(cars.getCarsDto());
            OutputView.printEnter();
        }
    }

    public void raceEnd() {
        OutputView.printWinners(cars.getWinnersNames());
    }

}
