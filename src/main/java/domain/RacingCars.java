package domain;

import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> carNames) {
        this.cars = generateCars(carNames);
    }

    private List<Car> generateCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(0);
    }
}
