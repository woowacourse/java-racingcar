package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private static final int MAX_SIZE = 40;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
        validate();
    }

    private void validate() {
        validateDuplicateName();
        validateSize();
    }

    private void validateDuplicateName() {
        if (cars.size() != cars.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 허용하지 않습니다.");
        }
    }

    private void validateSize() {
        if (cars.isEmpty() || cars.size() > MAX_SIZE) {
            throw new IllegalArgumentException("자동차의 대수는 1~40 사이입니다.");
        }
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
