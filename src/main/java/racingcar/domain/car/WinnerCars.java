package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {

    private final List<Car> container;

    public WinnerCars(final Cars cars) {
        container = cars.toList().stream()
                .filter(car -> car.isPosition(findMaxPosition(cars)))
                .collect(Collectors.toList());
    }

    private int findMaxPosition(final Cars cars) {
        return cars.toList().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(container);
    }
}
