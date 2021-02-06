package racingcar.controller;

import racingcar.domain.Car;

public class CarController {
    Car car;

    public CarController(final Car car) {
        this.car = car;
    }

    public void moveCar() {
        car.moveForward();
    }
}
