package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public void run(Cars cars, int trialNumber) {
        forwardCarsByTrialNumber(cars, trialNumber);
        OutputView.printWinners(cars.getWinnerNames());
    }

    private void forwardCarsByTrialNumber(Cars cars, int trialNumber) {
        for (int i = 0; i < trialNumber; i++) {
            cars.forward();
            OutputView.printCarsPosition(cars);
        }
    }
}
