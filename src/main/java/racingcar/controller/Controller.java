package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final Cars cars = getCars();
    private final int trialNumber = getTrialNumber();

    private Cars getCars() {
        try {
            return new Cars(InputView.getCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private int getTrialNumber() {
        try {
            return InputView.getTrialNumber();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getTrialNumber();
        }
    }

    public void run() {
        OutputView.printResultMessage();
        forwardCarsByTrialNumber();
        OutputView.printWinners(cars.getWinnerNames());
    }

    private void forwardCarsByTrialNumber() {
        for (int i = 0; i < trialNumber; i++) {
            forwardCars();
            OutputView.printCarsPosition(cars);
        }
    }

    private void forwardCars() {
        cars.forward();
    }
}
