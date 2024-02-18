package domain;

import domain.car.Car;
import domain.car.CarDistance;
import domain.car.Cars;
import java.util.List;

public class RacingRule {

    public List<Car> getWinners(final Cars cars) {
        final CarDistance maxDistance = cars.getMaxDistance();
        return cars.findCarsAtDistance(maxDistance);
    }
}
