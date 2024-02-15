package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicles {
    private final List<Car> cars;

    public static Vehicles from(String userInput) {
        validate(userInput);
        return new Vehicles(Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    private Vehicles(List<Car> cars) {
        this.cars = cars;
    }

    private static void validate(String userInput) {
        validateBlank(userInput);
        validateNonDuplicated(userInput);
    }

    private static void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNonDuplicated(String userInput) {
        if (hasDuplicateName(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateName(String userInput) {
        return userInput.split(",").length != Arrays.stream(userInput.split(","))
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
