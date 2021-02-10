package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;

    void createCars(String[] names) {
        this.cars = new Cars(names);
    }

    public void race() {
        OutputView.printResult();
        cars.startRace();
        OutputView.showStates(cars.getStates());
    }

    public void showWinners() {
        OutputView.printWinners(cars.showWinners());
    }
}
