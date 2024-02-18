package domain;

import java.util.List;
import java.util.Random;

public class Race {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Race(List<Car> cars, MoveStrategy moveStrategy) {
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
        return cars;
    }
}
