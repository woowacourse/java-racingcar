package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {

    private final Cars cars;

    public RacingGameResult(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        Position maxPosition = getMaxPosition();

        return cars.getCars().stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        return cars.getCars().stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new RuntimeException(""))
                .getPosition();
    }
}
