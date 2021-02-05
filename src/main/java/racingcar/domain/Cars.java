package racingcar.domain;

import racingcar.util.CarsValidator;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        CarsValidator.validate(cars);
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }
}
