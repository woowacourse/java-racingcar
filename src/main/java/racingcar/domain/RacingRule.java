package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarDistance;
import racingcar.domain.car.Cars;
import java.util.List;

public class RacingRule {

    public List<Car> getWinners(final Cars cars) {
        final CarDistance maxDistance = cars.getMaxDistance();
        return cars.findCarsAtDistance(maxDistance);
    }
}
