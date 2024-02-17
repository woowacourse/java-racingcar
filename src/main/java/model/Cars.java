package model;

import static util.Util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForward(generateRandomNumber());
        }
    }

    public List<String> findWinnerNames() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }


    @Override
    public String toString() {
        StringBuilder allTrace = new StringBuilder();
        for (Car car : cars) {
            allTrace.append(car).append("\n");
        }
        return allTrace.toString();
    }
}