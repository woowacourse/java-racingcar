package racingcar.domain;

import java.util.List;
import racingcar.util.RandomUtils;

public class Cars {
    private static final int MIN_DISTANCE = 0;
    private static final int RANDOM_MIN_LIMIT = 0;
    private static final int RANDOM_MAX_LIMIT = 9;
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> carNames) {
        validate(carNames);
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList()
        );
    }

    private static void validate(final List<String> carNames) {
        validateBlank(carNames);
        validateNonDuplicated(carNames);
    }

    private static void validateBlank(final List<String> carNames) {
        if (carNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNonDuplicated(final List<String> carNames) {
        if (hasDuplicateName(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateName(final List<String> carNames) {
        return carNames.size() != getDistinctNamesCount(carNames);
    }

    private static long getDistinctNamesCount(final List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count();
    }

    void move(final CarMoveStrategy carMovement, final RandomUtils randomUtil) {
        cars.forEach(car -> car.move(carMovement, randomUtil.generate(RANDOM_MIN_LIMIT, RANDOM_MAX_LIMIT)));
    }

    List<Car> findFarthestCars() {
        int farthestDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(MIN_DISTANCE);

        return cars.stream()
                .filter(car -> car.isDistance(farthestDistance))
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
