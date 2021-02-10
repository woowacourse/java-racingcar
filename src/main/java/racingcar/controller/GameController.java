package racingcar.controller;

import racingcar.domain.attemptnumber.AttemptNumber;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.RandomValueGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final String COMMA = ",";

    private Cars cars;
    private AttemptNumber attemptNumber;

    public void play() {
        init();
        OutputView.printExecutionResultMessage();
        while (attemptNumber.canAttempt()) {
            cars.move(new RandomValueGenerator());
            OutputView.printCarStateMessage(cars);
        }
        OutputView.printWinnerCarNamesMessage(cars.getWinners());
    }

    private void init() {
        cars = makeCars(InputView.getCarNames());
        attemptNumber = InputView.getAttemptNumber();
    }

    private Cars makeCars(String carNames) {
        String[] splitCarNames = carNames.split(COMMA);
        List<Car> inputCars = Arrays.stream(splitCarNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        return new Cars(inputCars);
    }
}