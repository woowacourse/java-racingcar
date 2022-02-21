package racingcar.controller;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.trycount.TryCount;
import racingcar.util.InputFormator;
import racingcar.util.MovableStrategy;
import racingcar.util.NumberValidator;
import racingcar.util.RacingCarMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final MovableStrategy racingCarMovableStrategy = new RacingCarMovableStrategy();
    private Cars cars = new Cars();
    private TryCount tryCount;

    public RaceController() {
    }

    public void start() {
        setUpCars();
        setUpTryCount();
        race();
        getWinners();
    }

    public void setUpCars() {
        try {
            InputFormator.toNameList(InputView.inputNames())
                .stream()
                .map(name -> new Car(name))
                .forEach(cars::add);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            setUpCars();
        }
    }

    public void setUpTryCount() {
        try {
            String input = InputView.inputTryCount();
            NumberValidator.validateStringIsNumber(input);
            tryCount = new TryCount(Integer.parseInt(input));
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            setUpTryCount();
        }
    }

    public void race() {
        OutputView.printRaceResult();
        for (int i = 0; i < tryCount.value(); i++) {
            cars.race(racingCarMovableStrategy);
            OutputView.printCars(cars);
        }
    }

    public void getWinners() {
        OutputView.printWinners(cars.getWinnersNames());
    }

}
