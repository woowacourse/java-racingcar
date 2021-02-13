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
        int maxPosition = getMaxPosition();

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.getCars().stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new RuntimeException(""))
                .getPosition();
    }
}
