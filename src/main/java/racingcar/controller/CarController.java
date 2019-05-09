package racingcar.controller;

import racingcar.dto.Car;

import java.util.List;

public class CarController {
    private List<Car> carList = null;

    public CarController(List<Car> carList) {
        this.carList = carList;
    }

    public void moveCar() {
        for (Car car : carList) {
            car.move();
        }
    }
}
