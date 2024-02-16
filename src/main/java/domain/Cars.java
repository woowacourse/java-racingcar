package domain;

import java.util.List;
import java.util.NoSuchElementException;

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

    public List<Car> chooseWinners() {
        int maxPosition = getFurthestPosition();
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .toList();
    }

    public void tryMoveAll() {
        cars.forEach(Car::tryMove);
    }

    private Integer getFurthestPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(
                        () -> new NoSuchElementException("가장 멀리 간 자동차의 위치를 구하는 것에 실패하였습니다\n 자동차 수: " + cars.size()));
    }
}
