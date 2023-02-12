package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinner() {
        List<Car> result = new ArrayList<>();
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

    private void addWinner(List<Car> result, Car car, int max) {
        if (car.getDistance() == max) {
            result.add(car);
        }
    }

    public Map<String, Integer> getCurrentStatus() {

        Map<String, Integer> carStatus = new HashMap<>();

        for (final Car car : cars) {
            carStatus.put(car.getName(), car.getDistance());
        }

        return carStatus;
    }

    public List<Car> getCars() {
        return cars;
    }
}
