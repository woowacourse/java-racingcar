package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidateException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class Cars {
    private List<Car> cars;

    public static final int MIN_CAR_SIZE = 2;
    public static final int MAX_CAR_SIZE = 5;

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
            throw new ValidateException(ExceptionMessage.CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateCarSize(List<Car> cars) {
        if (cars.size() < MIN_CAR_SIZE || cars.size() > MAX_CAR_SIZE) {
            throw new ValidateException(ExceptionMessage.CARS_SIZE_RANGE_ERROR_MESSAGE);
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
