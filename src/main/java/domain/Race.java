package domain;

import java.util.Collections;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final CarMove carMove;

    public Race(List<Car> cars, CarMove carMove) {
        this.cars = cars;
        this.carMove = carMove;
    }

    public void move() {
        cars.forEach(car -> car.move(carMove.isMove()));
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
