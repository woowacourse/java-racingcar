package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import racingcar.model.Car;

public class CarController {

    private static final int END_EXCLUSIVE = 10;

    private List<Car> cars;

    public CarController() {
    }

    public void createCars(String[] carNames) {
        cars = new ArrayList<>();
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
