package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void race() {
        cars.forEach(car -> car.move(Rules.generateRandomNumber()));
    }

    public RaceStatusDto getRaceStatus() {
        return new RaceStatusDto(cars);
    }

    public List<String> getWinners() {
        Car winnerCar = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.isMatchDistance(winnerCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
