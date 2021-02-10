package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.CarView;

public class CarController {
    private Car car;
    private CarView carView = new CarView();

    public CarController(final Car car) {
        this.car = car;
    }

    public void carMove(final int randomNumber) {
        car.carMove(randomNumber);
    }

    public void printCarStatus() {
        carView.printCarStatus(car);
    }
}
