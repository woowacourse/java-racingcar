package domain;

import java.util.Collections;
import java.util.List;
import java.util.function.IntSupplier;

public class Race {

    private static final int MAX_MOVABLE_DIGIT = 4;

    private final List<Car> cars;
    private final IntSupplier supplier;

    public Race(List<Car> cars, IntSupplier supplier) {
        this.cars = cars;
        this.supplier = supplier;
    }

    public void move() {
        cars.forEach(car -> car.move(isMove()));
    }

    private boolean isMove() {
        return supplier.getAsInt() >= MAX_MOVABLE_DIGIT;
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
