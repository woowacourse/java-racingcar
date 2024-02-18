package domain;

import utils.NumberGenerator;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
        if (isDuplicated(names)) {
            throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
        }
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    private static boolean isDuplicated(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    public void tryMove(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.tryMove(numberGenerator.generate());
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

    public void tryMove(List<NumberGenerator> numberGenerator) {
        for (int turn = 0; turn < cars.size(); turn++) {
            cars.get(turn).tryMove(numberGenerator.get(turn).generate());
        }
    }
}
