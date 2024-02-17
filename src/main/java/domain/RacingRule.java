package domain;

import java.util.List;

public class RacingRule {

    public List<Car> getWinners(final Cars cars) {
        final int maxDistance = cars.getMaxDistance();
        return cars.getCars()
                .stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }
}
