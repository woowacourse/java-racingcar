package model;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars {
    private final MovesGenerator movesGenerator;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.movesGenerator = new MovesGenerator();
        this.cars = cars;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(movesGenerator.doMove()));
    }

    public List<Car> findWinners() {
        int maxMovement = getMaxMovement();
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    private int getMaxMovement() {
        return cars.stream().mapToInt(Car::getMovement).max()
                .orElseThrow(() -> new NoSuchElementException("자동차의 최대 이동거리가 존재하지 않습니다."));
    }

    public List<Car> getPresentCarsStatus() {
        return Collections.unmodifiableList(cars);
    }
}
