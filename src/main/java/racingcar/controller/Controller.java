package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Cars cars = new Cars(getCars());
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

        OutputView.printWinners(cars.findWinners());
    }

    private void forwardCars() {
        cars.forward();
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();

        InputView.getCarNames()
                .stream()
                .forEach(carName -> cars.add(new Car(carName)));

        return cars;
    }

    private int getTrialNumber() {
        return InputView.getTrialNumber();
    }
}
