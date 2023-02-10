package racingcar.domain.car;

import racingcar.domain.game.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_SIZE = 2;
    private final List<Car> cars;

    public Cars(final List<String> cars) {
        if (cars.size() < MIN_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상 존재해야 합니다.");
        }
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public MovedResult move(final NumberGenerator generator) {
        cars.forEach(car -> car.move(generator.generate(MIN_NUMBER, MAX_NUMBER)));
        return new MovedResult(this);
    }

    List<Car> getCars() {
        return this.cars;
    }

    public List<Car> sortedCarsByPositionDesc() {
        List<Car> cars = new ArrayList<>(this.cars);
        cars.sort(Comparator.comparing(Car::getPosition));
        Collections.reverse(cars);
        return cars;
    }
}
