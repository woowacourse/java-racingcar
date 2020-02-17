package racingcar.domain;

import java.util.*;

/**
 * 자동차 목록 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class Cars {
    public static final int MIN_CARS_SIZE = 1;
    public static final int MAX_CARS_SIZE = 10;
    public static final String INPUT_NUMBERS_NOT_EQUAL_TO_CARS_MESSAGE = "Input numbers not equal to cars.";
    public static final String DUPLICATE_NAME_EXISTS_MESSAGE = "Duplicate name exists.";
    public static final String CAR_NUMBERS_OUT_OF_RANGE_MESSAGE = "Car numbers out of range(0,10).";

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCarsSize(cars);
        validateNotDuplicate(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    private void validateNotDuplicate(final List<Car> cars) {
        Set<Car> uniqueCars = new HashSet<>(cars);
        if (cars.size() != uniqueCars.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_EXISTS_MESSAGE);
        }
    }

    private void validateCarsSize(final List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(CAR_NUMBERS_OUT_OF_RANGE_MESSAGE);
        }
    }

    public boolean isPostionsOf(final List<Integer> postions) {
        validateSize(postions);
        for (int i = 0; i < cars.size(); i++) {
            if (!cars.get(i).isPositionOf(postions.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void validateSize(final List<Integer> input) {
        if (cars.size() != input.size()) {
            throw new IllegalArgumentException(INPUT_NUMBERS_NOT_EQUAL_TO_CARS_MESSAGE);
        }
    }

    public WinningRule getWinningRule() {
        return new WinningRule(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
