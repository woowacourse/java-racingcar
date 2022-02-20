package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.vo.Name;

public class Winner {
    private final List<Car> cars;

    public Winner(List<Car> cars) {
        validateEmpty(cars);
        this.cars = cars;
    }

    public List<Name> findWinners() {
        return findCoWinners(findWinner());
    }

    private Car findWinner() {
        Car maxPositionCar = Car.ZERO_POSITION;
        for (Car car : cars) {
            maxPositionCar = comparePosition(car, maxPositionCar);
        }
        return maxPositionCar;
    }

    private Car comparePosition(Car car, Car otherCar) {
        if (car.isGreaterThan(otherCar)) {
            return car;
        }
        return otherCar;
    }

    private List<Name> findCoWinners(Car firstCar) {
        return cars.stream()
            .filter(car -> car.isEqualPosition(firstCar))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private void validateEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 한대 이상이 필요합니다.");
        }
    }
}
