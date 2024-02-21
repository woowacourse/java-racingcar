package domain;

import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> carNames) {
        validate(carNames);
        this.cars = generateCars(carNames);
    }

    private void validate(List<String> carNames) {
        if (hasDuplication(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재 합니다.");
        }
    }

    private boolean hasDuplication(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }

    private List<Car> generateCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car> getMaxPositionCars() {
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
