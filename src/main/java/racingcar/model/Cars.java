package racingcar.model;

import racingcar.utils.RandomUtils;

import java.util.*;

public class Cars {

    public static final String CAR_NAME_INVALID = "자동차 이름이 유효하지 않습니다.";
    private static final int MAX_RANDOM_RANGE = 9;
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int DEFAULT_POSITION = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarsSize(cars);
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
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);
    }

    private void validateCarsSize(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> noDuplicateCars = new HashSet<>(cars);
        if (cars.size() != noDuplicateCars.size()) {
            throw new IllegalArgumentException(CAR_NAME_INVALID);
        }
    }
}
