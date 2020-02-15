package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarsInOneRace {
    private final List<Car> cars;

    public CarsInOneRace(List<String> carNames) {
        this.cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(car -> car.move(new RandomNumberWhetherMove()));
    }

    public List<Car> getWinners() {
        final int maxDistance = getMaxDistance();

        return cars.stream()
            .filter(car -> car.isWinner(maxDistance))
            .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}
