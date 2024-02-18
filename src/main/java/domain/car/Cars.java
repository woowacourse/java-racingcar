package domain.car;

import domain.moveStrategy.MoveStrategy;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames, MoveStrategy moveStrategy) {
        validateNames(carNames);
        this.cars = carNames.stream()
                .map(name -> new Car(name, moveStrategy))
                .toList();
    }

    private static void validateNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
        if (isDuplicated(carNames)) {
            throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
        }
    }

    private static boolean isDuplicated(List<String> carNames) {
        int distinctSize = (int) carNames.stream()
                .distinct()
                .count();
        return distinctSize != carNames.size();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void tryMove() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    public List<String> getWinnersName() {
        int maxLocation = getMaxLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }

    private int getMaxLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    public List<Car> getRoundResult() {
        return cars;
    }
}
