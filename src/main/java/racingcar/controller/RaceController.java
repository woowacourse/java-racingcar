package racingcar.controller;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.trycount.TryCount;
import racingcar.util.InputFormator;
import racingcar.util.NumberValidator;
import racingcar.util.RacingCarMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public RaceController() {
    }

    public void start() {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();
        race(cars, tryCount);
        getWinners(cars);
    }

    public Cars getCars() {
        Cars cars = new Cars();
        try {
            InputFormator.toNameList(InputView.inputNames())
                .stream()
                .map(name -> new Car(name.value()))
                .forEach(cars::add);
            return cars;
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return getCars();
        }
    }

    public TryCount getTryCount() {
        try {
            String input = InputView.inputTryCount();
            NumberValidator.validateStringIsNumber(input);
            return new TryCount(Integer.parseInt(input));
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return getTryCount();
        }
    }

    public void race(Cars cars, TryCount tryCount) {
        OutputView.printRaceResult();
        for (int i = 0; i < tryCount.value(); i++) {
            cars.race(new RacingCarMovableStrategy());
            OutputView.printCars(cars);
        }
    }

    public void getWinners(Cars cars) {
        OutputView.printWinners(cars.getWinnersNames());
    }

}
