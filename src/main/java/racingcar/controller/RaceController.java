package racingcar.controller;

import racingcar.model.*;
import racingcar.view.OutputView;
import racingcar.view.validator.InputValidator;
import racingcar.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<String> carNames = inputView.getCarNames();
        inputValidator.validateAvailableCarNames(carNames);
        int attemptNumber = inputView.getAttemptNumber();

        Cars cars = new Cars(carNames);
        runRace(cars, attemptNumber);
        printWinners(cars);
    }

    private void runRace(Cars cars, int attemptNumber) {
        outputView.printResultHeaderPrompt();
        for (int i = 0; i < attemptNumber; i++) {
            runEachRaceAndPrintResult(cars);
        }

    }

    private void runEachRaceAndPrintResult(Cars cars) {
        cars.moveAllCars();
        cars.getCars()
                .forEach(car -> outputView.printResult(car.getName(), car.getPosition()));
        OutputView.parseLine();
    }

    private void printWinners(Cars cars) {
        Referee referee = new Referee();
        outputView.printWinners(referee.determineWinnerNames(cars));
    }

}
