package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicles {
    private final List<Car> Cars;

    public static Vehicles from(String userInput) {
        validate(userInput);
        return new Vehicles(Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    private Vehicles(List<Car> cars) {
        Cars = cars;
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
        if (userInput.split(",").length != Arrays.stream(userInput.split(",")).collect(Collectors.toSet()).size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars() {
        return Cars;
    }
}
