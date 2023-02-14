package car.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> cars;
    private TrialCount trialCount;

    public Game(List<Car> cars, int trialCount) {
        validateCarsLength(cars);
        validateNoDuplicateCar(cars);
        this.cars = new ArrayList<>(cars);
        this.trialCount = new TrialCount(trialCount);
    }

    public void playOnceWith(MoveChance moveChance) {
        for (Car car : cars) {
            car.move(moveChance);
        }
        trialCount = trialCount.decrease();
    }

    public boolean isNotDone() {
        return trialCount.isLeft();
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

    private void validateNoDuplicateCar(List<Car> cars) {
        if (cars.size() > new HashSet<>(cars).size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되면 안됩니다");
        }
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
