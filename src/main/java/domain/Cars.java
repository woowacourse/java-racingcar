package domain;

import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Stream<Car> getStream() {
        return cars.stream();
    }
}
