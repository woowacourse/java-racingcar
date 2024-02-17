package domain;

import common.exception.model.ValidateException;

import java.util.List;


public class Cars {
    private List<Car> cars;

    private static final int MIN_CAR_SIZE = 2;
    private static final int MAX_CAR_SIZE = 5;
    public static final String CARS_SIZE_RANGE_ERROR_MESSAGE = String.format("자동차 수는 %d 이상, %d 이하여야 합니다", MIN_CAR_SIZE, MAX_CAR_SIZE);
    public static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "자동차 이름은 중복이 불가능합니다.";

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        validateCarSize(cars);
        validateCarNameDuplication(cars);
    }

    private void validateCarNameDuplication(List<Car> cars) {
        int actualCarAmount = cars.size();
        long distinctCarAmount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (actualCarAmount != distinctCarAmount) {
            throw new ValidateException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateCarSize(List<Car> cars) {
        if (cars.size() < MIN_CAR_SIZE || cars.size() > MAX_CAR_SIZE) {
            throw new ValidateException(CARS_SIZE_RANGE_ERROR_MESSAGE);
        }
    }

    public void tryMove() {
        for (Car car : cars) {
            car.pushAccelerator();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getWinnerPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        return maxPosition;
    }
}
