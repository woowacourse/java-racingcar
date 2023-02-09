package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarMovement;
import racingcar.domain.CarName;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarManager {
    private List<Car> cars;

    public CarManager(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarsRandomly() {
        this.cars.stream()
                .forEach(car -> car.move(makeRandomCarMove()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinners() {
        Car maxCar = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .collect(Collectors.toList());
    }

    private CarMovement makeRandomCarMove() {
        return new CarMovement((int) Math.random() * 10);
    }
}
