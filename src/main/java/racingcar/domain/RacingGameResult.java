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
//                .filter(car -> car.getPosition() == maxPosition)
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        return cars.getCars().stream()
                .max((car1, car2) -> car1.getPosition().compareTo(car2.getPosition()))
                .orElseThrow(() -> new RuntimeException(""))
                .getPosition();
    }
}
