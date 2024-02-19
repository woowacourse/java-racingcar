package model;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars {

    private static final String NOT_FIND_MAX_DISTANCE = "자동차의 최대 이동거리가 존재하지 않습니다.";
    private final MovesGenerator movesGenerator;
    private final List<Car> cars;

    public Cars(List<Car> cars, MovesGenerator movesGenerator) {
        this.movesGenerator = movesGenerator;
        this.cars = cars;
    }

    Cars(List<Car> cars) {
        this.cars = cars;
        this.movesGenerator = new MovesGenerator();
    }

    public void moveCars() {
        cars.forEach(car -> car.move(movesGenerator.doMove()));
    }

    public List<Car> findWinners() {
        int maxMovement = getMaxMovement();
        return cars.stream()
                .filter(car -> car.isSameMovement(maxMovement))
                .toList();
    }

    private int getMaxMovement() {
        return cars.stream().mapToInt(Car::getMovement).max()
                .orElseThrow(() -> new NoSuchElementException(NOT_FIND_MAX_DISTANCE));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
