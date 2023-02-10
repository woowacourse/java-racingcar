package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("최소 하나 이상의 Car 객체가 존재해야합니다.");
        }
    }

    public List<Car> getFirstPosition() {
        int maxPosition = this.getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.MIN_POSITION);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
