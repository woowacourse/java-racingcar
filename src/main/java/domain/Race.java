package domain;

import java.util.Collections;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final CarMoveStrategy moveStrategy;

    public Race(List<Car> cars, CarMoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        cars.forEach(car -> car.move(moveStrategy.isMove()));
    }

    public List<Car> findWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
