package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
