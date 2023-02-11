package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
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

    public List<String> getWinnerNames() {
        List<String> result = new ArrayList<>();
        int max = getMaxDistance();

        for (final Car car : cars) {
            addWinnerName(result, car, max);
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

    private void addWinnerName(List<String> result, Car car, int max) {
        if (car.getDistance() == max) {
            result.add(car.getName());
        }
    }

    public Map<String, Integer> getCurrentRacingStatus() {
        Map<String, Integer> carAndDistanceStatus = new HashMap<>();

        for (final Car car : cars) {
            carAndDistanceStatus.put(car.getName(), car.getDistance());
        }

        return carAndDistanceStatus;
    }
}
