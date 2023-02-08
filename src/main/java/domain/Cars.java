package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }
    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> moveByRandomNumber(numberGenerator, car));
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void moveByRandomNumber(NumberGenerator numberGenerator, Car car) {
        if (numberGenerator.generate() >= MINIMUM_NUMBER_TO_MOVE) {
            car.move();
        }
    }

    private List<Car> findSamePositionCars(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Cars가 비어있습니다."));
    }
}
