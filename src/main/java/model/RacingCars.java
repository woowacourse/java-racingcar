package model;

import exception.ErrorCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import service.NumberGenerator;

public class RacingCars {

    private static final int MAX_CAR_COUNT = 100;
    private final List<Car> cars;

    public RacingCars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public void move(final NumberGenerator generator, final int limit) {
        for (Car car : cars) {
            car.move(generator.generateNumber(limit));
        }
    }

    public Map<String, Integer> getCurrentPositions() {
        Map<String, Integer> carResult = new HashMap<>();
        cars.forEach(car -> carResult.put(car.getName(), car.getCurrentPosition()));
        return carResult;
    }

    public List<String> findWinner() {
        Map<String, Integer> positions = getCurrentPositions();
        Integer bestScore = Collections.max(positions.values());
        return positions.entrySet()
            .stream()
            .filter(status -> status.getValue().equals(bestScore))
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }

    private void validate(final List<Car> cars) {
        validateCarDuplicate(cars);
        validateCarCount(cars.size());
    }

    private void validateCarDuplicate(final List<Car> cars) {
        if (isCarDuplicate(cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList()))) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private void validateCarCount(final int size) {
        if (size > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(
                String.format(ErrorCode.TOO_MANY_CAR.getMessage(), MAX_CAR_COUNT));
        }
    }

    private boolean isCarDuplicate(final List<String> carNames) {
        return carNames.size() != carNames.stream()
            .distinct()
            .count();
    }
}
