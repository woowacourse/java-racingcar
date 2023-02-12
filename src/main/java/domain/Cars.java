package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.RandomPowerGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(final RandomPowerGenerator randomPowerGenerator) {
        for (final Car car : cars) {
            final int power = randomPowerGenerator.generateRandomPower();
            car.move(power);
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        final int maxCountOfDistance = findMaxCountOfDistance();

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

    private void addWinnerName(List<String> winnerNames, final Car car, final int maxCountOfDistance) {
        if (car.getDistance() == maxCountOfDistance) {
            winnerNames.add(car.getCarName());
        }
    }

    public Map<String, Integer> getCurrentRacingStatus() {
        Map<String, Integer> carAndDistanceStatus = new HashMap<>();

        for (final Car car : cars) {
            carAndDistanceStatus.put(car.getCarName(), car.getDistance());
        }

        return carAndDistanceStatus;
    }
}
