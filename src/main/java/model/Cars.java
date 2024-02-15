package model;

import static util.Util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_CAR_NAME_COUNT = 2;
    private static final int MIN_POSITION = 0;

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        validate(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    private static void validate(List<String> names) {
        checkDuplicatedName(names);
        checkNameCount(names);
    }

    private static void checkDuplicatedName(List<String> names) {
        long nameCount = names.stream().distinct().count();
        if (names.size() != nameCount) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    private static void checkNameCount(List<String> names) {
        if (names.size() < MIN_CAR_NAME_COUNT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 2개 이상이어야 합니다.");
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForward(generateRandomNumber());
        }
    }

    public List<String> findWinnerNames() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }


    @Override
    public String toString() {
        StringBuilder allTrace = new StringBuilder();
        for (Car car : cars) {
            allTrace.append(car).append("\n");
        }
        return allTrace.toString();
    }
}