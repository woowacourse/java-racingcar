package domain;

import java.util.List;

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
        int maxPosition = cars.stream().mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
