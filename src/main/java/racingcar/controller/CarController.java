package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import racingcar.model.Car;

public class CarController {

    private static final int END_EXCLUSIVE = 10;

    private final List<Car> cars;

    public CarController() {
        cars = new ArrayList<>();
    }

    public void createCars(final String[] carNames) {
        Arrays.stream(carNames)
            .forEach(carName -> cars.add(new Car(carName)));
    }

    public void moveCars() {
        cars.forEach(car -> car.moveForward(pickRandomNumber()));
    }

    private int pickRandomNumber() {
        return new Random().nextInt(END_EXCLUSIVE);
    }

    public List<Car> getCars() {
        return cars;
    }
}
