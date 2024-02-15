package domain;

import java.util.List;

public class RacingRule {

    public List<Car> getWinners(Cars cars) {
        int maxDistance = cars.getMaxDistance();

        return cars.getCars()
                .stream()
                .filter(car -> car.getStatus().distance() == maxDistance)
                .toList();
    }
}
