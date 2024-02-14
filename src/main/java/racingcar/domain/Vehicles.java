package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicles {
    private final List<Car> Cars;

    public static Vehicles from(String userInput) {
        return new Vehicles(Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    private Vehicles(List<Car> cars) {
        Cars = cars;
    }

    public List<Car> getCars() {
        return Cars;
    }
}
