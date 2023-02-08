package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_SIZE = 2;
    private final List<Car> cars;

    public Cars(final List<String> cars) {
        if (cars.size() < MIN_SIZE) {
            throw new IllegalArgumentException();
        }
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void move(final NumberGenerator generator) {
        cars.forEach(car -> car.move(generator.generate(MIN_NUMBER, MAX_NUMBER)));
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
