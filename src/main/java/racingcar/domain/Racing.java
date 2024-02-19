package racingcar.domain;

import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    Racing(final List<Car> cars, final MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public static Racing of(final List<String> carNames, final MoveStrategy moveStrategy) {
        final List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return new Racing(carList, moveStrategy);
    }

    public void move() {
        cars.forEach(car -> car.move(moveStrategy.isMove()));
    }

    public List<Car> findWinner() {
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.isPositionedAt(maxPosition))
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
