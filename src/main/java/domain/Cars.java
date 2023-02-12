package domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Cars {
    private static final String DUPLICATE_CAR_NAMES_ERROR_MESSAGE = "차 이름은 중복될 수 없습니다";
    private static final String EMPTY_CARS_ERROR_MESSAGE = "자동차가 존재하지 않습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        validateDuplicate(names);
        return names.stream()
                .map(Car::new)
                .collect(collectingAndThen(toUnmodifiableList(), Cars::new));
    }

    private static void validateDuplicate(List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES_ERROR_MESSAGE);
        }
    }

    private static int generateNumber(NumberGenerator numberGenerator) {
        return numberGenerator.generate();
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(generateNumber(numberGenerator)));
    }

    public List<String> identifyWinners() {
        Car winner = identifyWinner();

        return cars.stream()
                .filter(car -> isWinner(car, winner))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car identifyWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalStateException(EMPTY_CARS_ERROR_MESSAGE));
    }

    private boolean isWinner(Car car, Car winner) {
        return car.compareTo(winner) == 0;
    }

    public Map<String, Integer> getCarsPosition() {
        Map<String, Integer> result = new LinkedHashMap<>();
        cars.forEach(car -> result.put(car.getName(), car.getPosition()));

        return result;
    }
}
