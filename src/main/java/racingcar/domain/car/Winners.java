package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> container;

    public Winners(final List<Car> cars) {
        Car comparingCar = findAnyWinningInstance(cars);
        container = cars.stream()
                .filter(car -> car.inSamePosition(comparingCar))
                .collect(Collectors.toList());
    }

    private Car findAnyWinningInstance(final List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(container);
    }
}
