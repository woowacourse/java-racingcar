package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int CARS_MIN_SIZE = 1;
    private static final String CARS_SIZE_ERROR = "[ERROR] 자동차 대수는 1이상이어야 합니다.";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarsSize(cars);
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void validateCarsSize(List<Car> cars) {
        if (cars.size() < CARS_MIN_SIZE) {
            throw new IllegalArgumentException(CARS_SIZE_ERROR);
        }
    }
}
