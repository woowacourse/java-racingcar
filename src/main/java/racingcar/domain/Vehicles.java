package racingcar.domain;

import static racingcar.ui.OutputCommand.COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicles {
    private final List<Car> cars;

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

    void move(CarMoveStrategy carMoveStrategy) {
        cars.forEach(car -> car.move(carMoveStrategy));
    }

    List<Car> getBiggestCars() {
        int biggestForward = cars.stream().mapToInt(Car::getForward).max().getAsInt();
        return cars.stream().filter(car -> car.getForward() == biggestForward).toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
