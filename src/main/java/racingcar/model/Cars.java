package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
