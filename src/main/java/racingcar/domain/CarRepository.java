package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public void saveAll(List<Car> carsToSave) {
        cars.addAll(carsToSave);
    }

    public void deleteAll() {
        cars.clear();
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return Collections.unmodifiableList(cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList()));
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(RuntimeException::new);
    }
}
