package domain.racing;

import domain.car.Car;
import domain.car.Cars;

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
