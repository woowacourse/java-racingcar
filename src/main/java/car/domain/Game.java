package car.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> cars;
    private final MoveChance moveChance;

    public Game(List<Car> cars, MoveChance moveChance) {
        validateCarsLength(cars);
        this.cars = new ArrayList<>(cars);
        this.moveChance = moveChance;
    }

    public void playOnce() {
        for (Car car : cars) {
            car.move(moveChance);
        }
    }

    public List<Car> findWinners() {
        Car farthestCar = findFarthestCar();
        return cars.stream()
                .filter(car -> car.hasSamePositionWith(farthestCar))
                .collect(Collectors.toList());
    }

    private Car findFarthestCar() {
        return cars.stream()
                .reduce(this::getFartherCar)
                .orElseThrow(() -> new IllegalStateException("차량이 없습니다"));
    }

    private Car getFartherCar(Car car, Car other) {
        if (car.isFartherThan(other)) {
            return car;
        }
        return other;
    }

    private void validateCarsLength(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("차량이 없습니다");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
