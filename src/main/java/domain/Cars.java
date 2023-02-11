package domain;

import utils.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_POSITION = 0;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static Cars from(final List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void moveAll(final NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int number = numberGenerator.generate();
            car.move(number);
        }
    }

    public Cars findWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winningCars = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        return new Cars(winningCars);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);
    }

    public List<Car> getCars() {
        return cars;
    }
}
