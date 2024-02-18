package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static util.Util.generateRandomNumber;

public class Cars {

    private static final int MIN_CAR_NAME_COUNT = 2;
    private static final int MIN_POSITION = 0;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> names) {
        validateNames(names);

//        List<Car> cars = names.stream()
//                .map(Car::from)
//                .collect(Collectors.toList());

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }

        return new Cars(cars);
    }

    private static void validateNames(List<String> names) {
        checkDuplicatedName(names);
        checkNameCount(names);
    }

    private static void checkDuplicatedName(List<String> names) {
        long nameCount = names.stream().distinct().count();
        if (names.size() != nameCount) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void checkNameCount(List<String> names) {
        if (names.size() < MIN_CAR_NAME_COUNT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 2개 이상이어야 합니다.");
        }
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.moveForward(generateRandomNumber());
        }
//        this.cars.forEach(car -> car.moveForward(generateRandomNumber()));
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
        return this.cars;
    }
}
