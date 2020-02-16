package racingcar.domian;

import racingcar.domian.car.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static final int CAR_LIMIT = 5;
    private static final String DELIMITER = ",";
    private static final String CAR_COUNT_STR = "자동차 5대 초과입니다!";

    public List<Car> createCars(String carNames) {
        String[] names = carNames.split(DELIMITER);
        validateCarCount(names.length);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarCount(int carCount) {
        if (carCount > CAR_LIMIT) {
            throw new IllegalArgumentException(CAR_COUNT_STR);
        }
    }
}
