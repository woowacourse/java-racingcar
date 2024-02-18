package domain;

import domain.car.CarDistance;
import java.util.List;

public class RacingRule {

    public List<Car> getWinners(final Cars cars) {
        final CarDistance maxDistance = cars.getMaxDistance();
        return cars.getCars()
                .stream()
                .filter(car -> car.isAtDistance(maxDistance))
                .toList();
    }
}
