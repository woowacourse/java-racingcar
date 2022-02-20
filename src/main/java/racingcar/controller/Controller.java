package racingcar.controller;

import java.util.List;

import racingcar.model.Cars;
import racingcar.utils.generator.NameGenerator;
import racingcar.utils.generator.TrialNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private Cars cars;
    private int trialNumber;

    public void run() {
        initialize();
        OutputView.printResultMessage();
        forwardCarsByTrialNumber();
        OutputView.printWinnerNames(cars.findWinnerNames());
    }

    private void initialize() {
        cars = new Cars();
        addCarNamesToCars();
        trialNumber = getTrialNumber();
    }

    private void forwardCarsByTrialNumber() {
        for (int i = 0; i < trialNumber; i++) {
            forwardCars();
            OutputView.printCarsPosition(cars.getCars());
        }
    }

    private void forwardCars() {
        cars.forward();
    }

    private void addCarNamesToCars() {
        try {
            List<String> carNames = NameGenerator.generateCarNames(InputView.getCarNames());
            cars.add(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private int getTrialNumber() {
        String input = InputView.getTrialNumber();
        try {
            return TrialNumberGenerator.generateTrialNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getTrialNumber();
        }
    }
}
