package racingcar.controller;

import racingcar.domain.Car;

public class CarController {
    Car car;

    public CarController(Car car) {
        this.car = car;
    }

    public void carMove() {
        car.carMove();
    }
}
