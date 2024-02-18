package domain;

import utils.NumberGenerator;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names, NumberGenerator numberGenerator) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
        if (isDuplicated(names)) {
            throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
        }
        this.cars = names.stream()
                .map(name -> new Car(name, numberGenerator))
                .toList();
    }

    private static boolean isDuplicated(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void tryMove() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    public List<String> findWinnersName() {
        int maxLocation = findMaxLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }

    private int findMaxLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    public List<Car> getRoundResult() {
        return cars;
    }
}
