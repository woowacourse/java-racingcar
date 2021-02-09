package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        validateNonDuplicatedNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateNonDuplicatedNames(final List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void race() {
        cars.forEach(car -> car.moveForward(RandomUtils.createRandomNumber()));
    }

    public Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalStateException::new);
    }
}
