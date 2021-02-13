package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private static final String NAME_SPLIT_DELIMITER = ",";
    private static final int MIN_CARS_LENGTH = 2;
    private final List<Car> cars = new ArrayList<>();
    private int maxPosition;

    public Cars(String input) {
        String[] carNames = splitInput(input);
        for (String name : carNames) {
            this.cars.add(new Car(name, 0));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void findMaxPosition() {
        maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    public List<String> findWinner() {
        return cars.stream()
            .filter(car -> isWinner(car))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private String[] splitInput(String input) {
        String[] carNames = Arrays.stream(input.split(NAME_SPLIT_DELIMITER, -1))
            .map(String::trim)
            .toArray(String[]::new);
        validateCarsLength(carNames);
        validateDuplication(carNames);
        return carNames;
    }

    private static void validateCarsLength(String[] carNames) {
        if (carNames.length < MIN_CARS_LENGTH) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    private static void validateDuplication(String[] carNames) {
        HashSet<String> nameSet = new HashSet<>();
        Collections.addAll(nameSet, carNames);
        if (carNames.length != nameSet.size()) {
            throw new IllegalArgumentException("중복되는 이름을 입력할 수 없습니다.");
        }
    }

    private boolean isWinner(Car car) {
        return car.isPosition(maxPosition);
    }
}
