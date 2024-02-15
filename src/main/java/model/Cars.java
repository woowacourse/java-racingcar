package model;

import static util.Util.generateRandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_CAR_NAME_COUNT = 2;
    private static final int MIN_POSITION = 0;
    private static final String NEW_LINE = "\n";
    private static final String PREFIX_ERROR = "[ERROR] ";
    private static final String ERROR_DUPLICATED_NAME = "자동차의 이름은 중복될 수 없습니다.";
    private static final String ERROR_NAME_COUNT = "자동차 이름은 2개 이상이어야 합니다.";

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        validateDuplicatedName(names);
        validateNameCount(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }
        return new Cars(cars);
    }

    private static void validateDuplicatedName(List<String> names) {
        long nameCount = names.stream().distinct().count();
        if (names.size() != nameCount) {
            throw new IllegalArgumentException(PREFIX_ERROR + ERROR_DUPLICATED_NAME);
        }
    }

    private static void validateNameCount(List<String> names) {
        if (names.size() < MIN_CAR_NAME_COUNT) {
            throw new IllegalArgumentException(PREFIX_ERROR + ERROR_NAME_COUNT);
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
        int maxPosition = MIN_POSITION;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
    
    @Override
    public String toString() {
        StringBuilder allTrace = new StringBuilder();
        for (Car car : cars) {
            allTrace.append(car).append(NEW_LINE);
        }
        return allTrace.toString();
    }
}
