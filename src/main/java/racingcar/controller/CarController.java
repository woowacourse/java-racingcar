package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;

    void createCars(String[] names) {
        this.cars = new Cars(names);
    }

    void race() {
        OutputView.printResult();
        cars.startRace();
        OutputView.showStates(cars.getStates());
    }

    void showWinners() {
        OutputView.printWinners(cars.showWinners());
    }
}
