package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private static final int POWER_THRESHOLD = 4;

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> proceed() {
        for (Car car : cars) {
            applyStatus(new Random().nextInt(10), car);
        }
        return new ArrayList<>(cars);
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
}
