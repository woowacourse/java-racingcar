package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findFirstCars() {
        Car maxPositionCar = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private Car findMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차 위치의 최대값을 구할 수 없습니다."));
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int moveNumber = numberGenerator.generate();
            car.move(moveNumber);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
