package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> container;

    public Winners(final List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        container = cars.stream()
                .filter(car -> car.isPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int findMaxPosition(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(container);
    }
}
