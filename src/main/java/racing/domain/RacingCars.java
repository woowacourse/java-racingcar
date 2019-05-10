package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public void race() {
        carList.forEach(Car::move);
    }

    public RaceStatusDto getRaceStatus() {
        return new RaceStatusDto(carList);
    }

    public List<String> getWinners() {
        Car winnerCar = Collections.max(carList);
        return carList.stream()
                .filter(car-> car.isMatchDistance(winnerCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
