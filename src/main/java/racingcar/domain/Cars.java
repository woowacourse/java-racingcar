package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validateNonDuplicatedNames(cars);
    }

    private static void validateNonDuplicatedNames(final List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        if (new HashSet<>(carNames).size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }

    public static Cars makeFromCarNames(final List<Name> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
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
