package racingcar.model;

import racingcar.utils.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    public static final String CAR_NAME_INVALID = "자동차 이름이 유효하지 않습니다.";
    public static final int MAX_RANDOM_RANGE = 9;
    public static final int MIN_RANDOM_RANGE = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateUserCount(cars);
        validateDuplicate(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.stream()
                .forEach(car -> car.movePosition(RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE)));
    }

    public int getMaxDistance() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition)).get().getPosition();
    }

    private void validateUserCount(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }

    private void validateDuplicate(List<Car> cars) {
        if (!cars.stream()
                .filter(count -> Collections.frequency(cars, count) > 1)
                .collect(Collectors.toSet()).isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }
}
