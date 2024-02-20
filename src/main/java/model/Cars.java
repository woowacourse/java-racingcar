package model;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static util.Util.generateRandomNumber;

public class Cars {

    private static final int MIN_CAR_NAME_COUNT = 2;
    private static final int MIN_POSITION = 0;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<Car> cars) {
        validateNames(cars);

        return new Cars(cars);
    }

    private static void validateNames(List<Car> cars) {
        checkDuplicatedName(cars);
        checkNameCount(cars);
    }

    private static void checkDuplicatedName(List<Car> cars) {
        Set<String> uniqueNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void checkNameCount(List<Car> names) {
        if (names.size() < MIN_CAR_NAME_COUNT) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 자동차 이름은 %d개 이상이어야 합니다.",
                            MIN_CAR_NAME_COUNT));
        }
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.moveForward(generateRandomNumber());
        }
    }

    public List<String> findMaxPositionCarName() {
        int maxPosition = calculateMaxPosition();

        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int calculateMaxPosition() {
        return this.cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(MIN_POSITION);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
