package model;

import static util.Util.generateRandomNumber;
import static view.OutputView.ERROR_PREFIX;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MIN_CAR_NAME_COUNT = 2;
    private static final int MIN_POSITION = 0;
    private static final String NAME_DELIMITER = " : ";
    private static final String TRACE = "-";
    private static final String NEW_LINE = "\n";

    private List<Car> cars;

    private RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingGame from(List<String> names) {
        validate(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }
        return new RacingGame(cars);
    }

    private static void validate(List<String> names) {
        checkDuplicatedName(names);
        checkNameCount(names);
    }

    private static void checkDuplicatedName(List<String> names) {
        long nameCount = names.stream().distinct().count();
        if (names.size() != nameCount) {
            throw new IllegalArgumentException(ERROR_PREFIX + "자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void checkNameCount(List<String> names) {
        if (names.size() < MIN_CAR_NAME_COUNT) {
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForward(generateRandomNumber());
        }
    }

    public List<String> findWinnerNames() {
        int maxPosition = calculateMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

    public String showAllCarTrace() {
        StringBuilder allTrace = new StringBuilder();
        for (Car car : cars) {
            allTrace.append(car.showTrace(NAME_DELIMITER, TRACE)).append(NEW_LINE);
        }
        return allTrace.toString();
    }
}
