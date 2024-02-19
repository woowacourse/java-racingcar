package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Vehicles {
    private static final String CAR_NAMES_DELIMITER = ",";
    private final List<Car> cars;

    private Vehicles(List<Car> cars) {
        this.cars = cars;
    }

    public static Vehicles from(String carNames) {
        validate(carNames);
        return new Vehicles(Arrays.stream(carNames.split(CAR_NAMES_DELIMITER))
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
        return carNames.split(CAR_NAMES_DELIMITER).length != Arrays.stream(carNames.split(CAR_NAMES_DELIMITER))
                .collect(Collectors.toSet()).size();
    }

    void move(BiConsumer<String, Integer> doEachCarAfterMove) {
        cars.forEach(car -> {
            car.move();
            doEachCarAfterMove.accept(car.getName(), car.getForward());
        });
    }

    List<Car> getBiggestCars() {
        int biggestForward = cars.stream()
                .mapToInt(Car::getForward)
                .max()
                .getAsInt();
        return cars.stream().filter(car -> car.getForward() == biggestForward).toList();
    }
}
