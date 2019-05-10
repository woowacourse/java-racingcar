package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        cars.forEach(Car::move);
    }

    public RaceStatusDto getRaceStatus() {
        return new RaceStatusDto(cars);
    }

    public List<String> getWinners() {
        Car winnerCar = Collections.max(cars);
        return cars.stream()
                .filter(car-> car.isMatchDistance(winnerCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
