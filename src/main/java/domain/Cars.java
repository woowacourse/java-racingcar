package domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private static final String SPLIT_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String carsName) {
        this.cars = makeCars(carsName);
    }

    private List<Car> makeCars(String carsName) {
        return Arrays.stream(carsName.split(SPLIT_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (final Car car : cars) {
            doRace(car);
        }
    }

    private void doRace(final Car car) {
        if (canMove()) {
            car.move();
        }
    }

    private boolean canMove() {
        return RandomNumberGenerator.generateRandomNumber() >= 4;
    }

    public List<String> getWinner() {
        List<String> result = new ArrayList<>();
        int max = getMaxDistance();

        for (final Car car : cars) {
            addWinner(result, car, max);
        }

        return result;
    }

    private int getMaxDistance() {
        int max = Integer.MIN_VALUE;
        for (final Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        return max;
    }

    private void addWinner(List<String> result, Car car, int max) {
        if (car.getDistance() == max) {
            result.add(car.getName());
        }
    }

    public Map<String, Integer> getCurrentStatus() {
        Map<String, Integer> carStatus = new HashMap<>();

        for (final Car car : cars) {
            carStatus.put(car.getName(), car.getDistance());
        }

        return carStatus;
    }
}
