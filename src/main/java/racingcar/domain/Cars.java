package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Cars {
    private static final int MINIMUM_CAR_NAME_QUANTITY = 2;

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Cars(final List<Car> cars, final MoveStrategy moveStrategy) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. List<Car>타입을 사용하세요.");
        }
        if (Objects.isNull(moveStrategy)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. MoveStrategy타입을 사용하세요.");
        }

        checkCars(cars);

        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    private void checkCars(final List<Car> cars) {
        checkDuplicateName(cars);
        checkMinimumCarQuantity(cars);
    }

    private void checkMinimumCarQuantity(final List<Car> cars) {
        if (hasMinimumCarName(cars)) {
            throw new IllegalArgumentException("최소 자동차 수는 " + MINIMUM_CAR_NAME_QUANTITY + " 개 이상이어야 합니다.");
        }
    }

    private void checkDuplicateName(final List<Car> cars) {
        if (hasDuplicateName(cars)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private boolean hasMinimumCarName(final List<Car> cars) {
        return cars.size() < MINIMUM_CAR_NAME_QUANTITY;
    }

    private boolean hasDuplicateName(final List<Car> cars) {
        return cars.stream().distinct().count() != cars.size();
    }

    public void attemptToMoveCars() {
        for (final Car car : cars) {
            car.attemptToMove(moveStrategy.isMove());
        }
    }

    public List<Car> findWinners() {
        final Car maxPositionCar = getMaxPositionCar();
        return cars.stream().filter(car -> car.isSamePositionWith(maxPositionCar))
                .collect(java.util.stream.Collectors.toUnmodifiableList());
    }

    private Car getMaxPositionCar() {
        return cars.stream().max(Car::compareTo).orElseThrow(NoSuchElementException::new);
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }
}
