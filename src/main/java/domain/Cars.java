package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberGenerator numberGenerator) {
        cars.stream()
                .filter(car -> car.canMove(numberGenerator.generate()))
                .forEach(Car::move);
    }

    public List<Car> getWinners() {
        int maxCount = getMaxMoveCount();
        return cars.stream()
                .filter(car -> car.isWinner(maxCount))
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
