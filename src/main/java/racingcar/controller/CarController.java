package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.CarMoveRule;
import racingcar.view.OutputView;

public class CarController {
    private Cars cars;

    void createCars(String[] names) {
        this.cars = new Cars(names, new CarMoveRule());
    }

    public void race(int time, OutputView outputView) {
        outputView.printResult();
        for (int i = 0; i < time; i++) {
            cars.startRace();
            outputView.showState(cars.getStates());
        }
    }

    public void showWinners(OutputView outputView) {
        outputView.printWinners(cars.showWinners());
    }
}
