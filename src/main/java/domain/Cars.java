package domain;

import java.util.List;
import java.util.NoSuchElementException;

public class Cars {

    private final List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::from)
                .toList());
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
                        () -> new NoSuchElementException(
                                "[INTERNAL ERROR] 가장 먼 자동차 위치 구하기 실패\n 자동차 수: " + cars.size()));
    }
}
