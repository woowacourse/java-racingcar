package racingcar.model.car;

import racingcar.model.trycount.TryCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String TO_STRING_DELIMITER = "\n";

    private final List<Car> cars = new ArrayList<>();

    private Cars() {

    }

    public static Cars create() {
        return new Cars();
    }

    public void add(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다.");
        }

        cars.add(car);
    }

    public void moveAll(TryCount tryCount) {
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.forEach(Car::move);
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(TO_STRING_DELIMITER));
    }
}
