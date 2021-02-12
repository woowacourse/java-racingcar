package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }

    public void createCarsByCarNames(List<String> carNames) {
        List<Car> newCars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());

        cars.addAll(newCars);
    }

    public int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalStateException::new);
    }
}
