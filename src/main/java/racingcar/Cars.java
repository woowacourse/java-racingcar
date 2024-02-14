package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String input) {
        validateInput(input);
        this.cars = Arrays.stream(input.split(","))
                .map(Car::new)
                .toList();
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty() || input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }
}
