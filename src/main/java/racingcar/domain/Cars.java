package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int FIRST_INDEX = 0;
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

    public List<Car> winners() {
        List<Car> cars = sortedCars();
        Car winner = cars.get(FIRST_INDEX);

        return cars.stream()
                .filter(it -> it.getPosition().equals(winner.getPosition()))
                .collect(Collectors.toList());
    }

    private List<Car> sortedCars() {
        List<Car> cars = new ArrayList<>(this.cars);
        cars.sort(Comparator.comparing(Car::getPosition));
        Collections.reverse(cars);
        return cars;
    }
}
