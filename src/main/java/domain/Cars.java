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

    public void moveAll() {
        for (final Car car : cars) {
            startMove(car);
        }
    }

    private void startMove(final Car car) {
        if (canMove()) {
            car.move();
        }
    }

    private boolean canMove() {
        return RandomNumberGenerator.generateRandomNumber() >= 4;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxCountOfDistance = getMaxDistance();

        for (final Car car : cars) {
            addWinnerName(winnerNames, car, maxCountOfDistance);
        }

        return winnerNames;
    }

    private int getMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;
        for (final Car car : cars) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    private void addWinnerName(List<String> result, Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
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
