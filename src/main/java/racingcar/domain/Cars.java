package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> names) {
        validateNonDuplicatedNames(names);
        for (String name : names) {
            cars.add(new Car(new Name(name)));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMaxPositionByCars() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public void moveCars() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            car.carMove(getMovePivot(randomNumberGenerator));
        }
    }

    protected int getMovePivot(final RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.getNumber();
    }

    private void validateNonDuplicatedNames(final List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }
}
