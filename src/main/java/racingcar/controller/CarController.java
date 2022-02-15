package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.model.Car;
import racingcar.utils.RandomNumberGenerator;

public class CarController {

    private final List<Car> cars;

    public CarController() {
        cars = new ArrayList<>();
    }

    public void createCars(final String[] carNames) {
        Arrays.stream(carNames)
                .forEach(carName -> cars.add(new Car(carName)));
    }

    public void moveCars() {
        cars.forEach(car -> car.moveForward(RandomNumberGenerator.pickRandomNumber()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
