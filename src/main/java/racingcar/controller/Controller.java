package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final Cars cars = new Cars(InputView.getCarNames());
    private final int trialNumber = getTrialNumber();

    public void run() {
        play();
    }

    private void play() {
        OutputView.printResultMessage();

        for (int i = 0; i < trialNumber; i++) {
            forwardCars();
            OutputView.printCarsPosition(cars);
        }
    }

    private void forwardCars() {
        cars.forward();
    }

    private int getTrialNumber() {
        return InputView.getTrialNumber();
    }
}
