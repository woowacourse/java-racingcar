package racingcar.controller;

import java.util.Arrays;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.Name;
import racingcar.model.trycount.TryCount;
import racingcar.util.MovableStrategy;
import racingcar.util.NumberValidator;
import racingcar.util.RacingCarMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private static final String INPUT_DELIMITER = ",";
    private final MovableStrategy racingCarMovableStrategy = new RacingCarMovableStrategy();
    private Cars cars = new Cars();
    private TryCount tryCount;

    public RaceController() {
    }

    public void start() {
        setUpCars();
        setUpTryCount();
        race();
        raceEnd();
    }

    public void setUpCars() {
        try {
            cars = getCarsFromInput(InputView.inputNames());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            setUpCars();
        }
    }

    public Cars getCarsFromInput(String input) {
        Cars cars = new Cars();
        String[] names = input.split(INPUT_DELIMITER);
        if (names.length == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
        }
        Arrays.stream(names)
            .map(Name::new)
            .map(name -> new Car(name))
            .forEach(cars::add);
        return cars;
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
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.race(racingCarMovableStrategy);
            OutputView.printCars(cars.getCarsDto());
        }
    }

    public void raceEnd() {
        OutputView.printWinners(cars.getWinnersNames());
    }

}
