package racingcar.controller;

import racingcar.TryCount;
import racingcar.dto.Car;

import java.util.List;

public class CarController {
    private List<Car> carList = null;
    private TryCount tryCount;

    public CarController(List<Car> carList, TryCount tryCount) {
        this.carList = carList;
        this.tryCount = tryCount;
    }

    public void raceCar() {
        for (int i = 0; i < tryCount.getCount(); i++) {
            moveCar();
        }
    }

    public void moveCar() {
        for (Car car : carList) {
            car.move();
        }
    }
}
