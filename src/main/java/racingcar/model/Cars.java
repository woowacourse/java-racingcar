package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validate(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    private void validate(final List<Car> cars) {
        if (cars.size() != cars.stream()
                .distinct()
                .toList()
                .size()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 허용하지 않습니다.");
        }
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
