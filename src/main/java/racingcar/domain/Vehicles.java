package racingcar.domain;

import static racingcar.ui.OutputCommand.COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;

public class Vehicles {
    private static final int MIN_DISTANCE = 0;
    private static final int RANDOM_MIN_LIMIT = 0;
    private static final int RANDOM_MAX_LIMIT = 9;
    private final List<Car> cars;
    RandomUtil randomUtil = RandomUtil.getInstance();

    public static Vehicles from(final String userInput) {
        validate(userInput);
        return new Vehicles(Arrays.stream(userInput.split(COMMA))
                .map(String::trim)
                .map(Car::new)
                .toList()
        );
    }

    private Vehicles(final List<Car> cars) {
        this.cars = cars;
    }

    private static void validate(final String userInput) {
        validateBlank(userInput);
        validateNonDuplicated(userInput);
    }

    private static void validateBlank(final String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNonDuplicated(final String userInput) {
        if (hasDuplicateName(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateName(final String userInput) {
        return userInput.split(COMMA).length != Arrays.stream(userInput.split(COMMA))
                .collect(Collectors.toSet()).size();
    }

    void move(final CarMoveStrategy carMoveStrategy) {
        cars.forEach(car -> car.move(carMoveStrategy, randomUtil.generate(RANDOM_MIN_LIMIT, RANDOM_MAX_LIMIT)));
    }

    List<Car> findFarthestCars() {
        int farthestDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(MIN_DISTANCE);
        return cars.stream().filter(car -> car.getDistance() == farthestDistance).toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
