package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class CarsValidator {
    private static final int MIN_CARS_SIZE = 2;

    public static void validateCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상 이어야 합니다.");
        }
    }
}
