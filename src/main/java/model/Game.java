package model;

import message.Exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private static final int POWER_THRESHOLD = 4;

    private final List<Car> cars;

    public Game(List<String> carsName) {
        validateNotDuplicate(carsName);
        this.cars = convertToCar(carsName);
    }

    private void validateNotDuplicate(List<String> carsName) {
        int originCount = carsName.size();
        int distinctCount = (int) carsName.stream().distinct().count();
        if (originCount != distinctCount) {
            throw new IllegalArgumentException(Exception.DUPLICATE.getMessage());
        }
    }

    private List<Car> convertToCar(List<String> carsName) {
        return carsName.stream().map(Car::new).toList();
    }

    public void proceed() {
        for (Car car : cars) {
            applyStatus(new Random().nextInt(10), car);
        }
    }

    private void applyStatus(int power, Car car) {
        if (power > POWER_THRESHOLD) {
            car.forward();
            return;
        }
        car.stop();
    }

    public List<Car> findWinners() {
        int winnersScore = Collections.max(cars.stream().map(Car::getForwardCount).toList());
        return cars.stream().filter(car -> car.getForwardCount() == winnersScore).toList();
    }

    List<Car> findWinners(List<Car> cars) {
        int winnersScore = Collections.max(cars.stream().map(Car::getForwardCount).toList());
        return cars.stream().filter(car -> car.getForwardCount() == winnersScore).toList();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
