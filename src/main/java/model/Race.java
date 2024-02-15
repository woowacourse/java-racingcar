package model;

import static utils.RandomNumberGenerator.generateRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(String nameStr) {
        cars = new ArrayList<>();
        String[] names = nameStr.split(",");
        for (String name : names) {
            cars.add(new Car(new Name(name)));
        }
    }

    public void oneGame() {
        for (Car car : cars) {
            executeRandomMove(car, generateRandomNumber());
        }
    }

    private static void executeRandomMove(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.move();
        }
    }
}
