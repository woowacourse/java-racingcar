package domain;

import java.util.List;
import java.util.stream.Stream;

import utils.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate()));
    }

    public Stream<Car> getStream() {
        return cars.stream();
    }
}
