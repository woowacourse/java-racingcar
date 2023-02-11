package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final NumberGenerator numberGenerator;

    public RacingCarController() {
        this.numberGenerator = new RandomNumberGenerator();
    }

    public void run() {
        Cars cars = initCars();
        int tries = initTries();
        OutputView.printResultMessage();
        List<CarStatus> result = race(cars, tries, numberGenerator);
        showResult(result);
        prizeWinner(cars);
    }

    private Cars initCars() {
        try {
            String input = InputView.inputCarNames();
            List<String> carNames = splitCarNames(input);
            return new Cars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initCars();
        }
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private int initTries() {
        try {
            return InputView.inputTries();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initTries();
        }
    }

    private List<CarStatus> race(Cars cars, int tries, NumberGenerator numberGenerator) {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (int i = 0; i < tries; i++) {
            carStatuses = cars.moveCars(numberGenerator);
            OutputView.printCarStatus(carStatuses);
        }
        return carStatuses;
    }

    private void showResult(List<CarStatus> result) {
        OutputView.printCarStatus(result);
    }

    private void prizeWinner(Cars cars) {
        List<String> winnersName = cars.getWinnerCarsName();
        OutputView.printFinalResult(winnersName);
    }
}
