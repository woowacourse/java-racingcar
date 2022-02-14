package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Cars cars;
    private int trialNumber;

    public void run() {
        initialize();
        OutputView.printResultMessage();
        forwardCarsByTrialNumber();
        OutputView.printWinners(cars.findWinners());
    }

    private void initialize() {
        cars = new Cars(getCars());
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

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();

        InputView.getCarNames()
                .forEach(carName -> cars.add(new Car(carName)));

        return cars;
    }

    private int getTrialNumber() {
        return InputView.getTrialNumber();
    }
}
