package domain.racing;

import domain.car.Car;

import java.util.List;

public class RacingRule {

    public List<Car> findWinnerCars(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);

        if (maxDistance == 0) {
            return List.of();
        }

        return cars.stream()
                .filter(car -> car.isDistanceEqual(maxDistance))
                .toList();
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.getStatus().distance())
                .max()
                .orElseGet(() -> 0);
    }
}
