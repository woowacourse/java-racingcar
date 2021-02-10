package racingcar.controller;

import racingcar.domain.attemptnumber.AttemptNumber;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.RandomValueGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private static final String NO_NAME_ERROR = "반드시 자동차 이름을 입력하셔야 합니다.";
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
        List<Car> inputCars = new ArrayList<>();
        String[] splitCarNames = carNamesSplit(carNames);
        for (String carName : splitCarNames) {
            inputCars.add(new Car(carName));
        }
        return new Cars(inputCars);
    }

    private String[] carNamesSplit(String carNames) {
        String[] splitCarNames = carNames.split(COMMA);
        if (splitCarNames.length == 0) {
            throw new IllegalArgumentException(NO_NAME_ERROR);
        }
        return splitCarNames;
    }
}