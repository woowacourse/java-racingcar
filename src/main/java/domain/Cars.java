package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void tryMoveAll() {
        for (final Car car : cars) {
            car.tryMove();
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxCountOfDistance = findMaxCountOfDistance();

        for (final Car car : cars) {
            addWinnerName(winnerNames, car, maxCountOfDistance);
        }

        return winnerNames;
    }

    private int findMaxCountOfDistance() {
        int maxCountOfDistance = Integer.MIN_VALUE;
        for (final Car car : cars) {
            maxCountOfDistance = Math.max(car.getDistance(), maxCountOfDistance);
        }
        return maxCountOfDistance;
    }

    private void addWinnerName(List<String> winnerNames, Car car, int maxCountOfDistance) {
        if (car.getDistance() == maxCountOfDistance) {
            winnerNames.add(car.getName());
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
