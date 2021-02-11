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

    public List<Car> getWinners() {
        int maxPositionOfAllCars = getMaxPositionOfAllCars();

        return Collections.unmodifiableList(
            cars.stream()
                .filter(car -> car.getPosition() == maxPositionOfAllCars)
                .collect(Collectors.toList())
        );
    }

    private int getMaxPositionOfAllCars() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalStateException::new);
    }
}
