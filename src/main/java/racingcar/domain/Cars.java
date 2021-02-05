package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of (List<String> carNames) {

        List<Car> cars = new ArrayList<>();
        carNames.stream()
                .map(Car::from)
                .forEach(cars::add);
        return new Cars(cars);
    }
}
