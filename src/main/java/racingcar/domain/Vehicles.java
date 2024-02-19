package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.ui.OutputCommand.COMMA;

public class Vehicles {
    private final List<Car> cars;

    private Vehicles(List<Car> cars) {
        this.cars = cars;
    }

    public static Vehicles from(String carNames) {
        validate(carNames);
        return new Vehicles(Arrays.stream(carNames.split(COMMA))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    private static void validate(String carNames) {
        validateBlank(carNames);
        validateNonDuplicated(carNames);
    }

    private static void validateBlank(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNonDuplicated(String carNames) {
        if (hasDuplicateName(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateName(String carNames) {
        return carNames.split(COMMA).length != Arrays.stream(carNames.split(COMMA))
                .collect(Collectors.toSet()).size();
    }

    void move() {
        cars.forEach(Car::move);
    }

    List<Car> getBiggestCars() {
        int biggestForward = cars.stream().mapToInt(Car::getForward).max().getAsInt();
        return cars.stream().filter(car -> car.getForward() == biggestForward).toList();
    }
}
