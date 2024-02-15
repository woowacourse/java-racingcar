package domain;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
    
    public List<Car> chooseWinner() {
        int maxPosition = getFurthestPosition();
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .toList();
    }

    public void tryMoveAll() {
        cars.forEach(car -> car.tryMove());
    }

    private Integer getFurthestPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }
}
