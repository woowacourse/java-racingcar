package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racing.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    private void validateDuplicateName(List<Car> cars) {
        Set<String> distinctNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (distinctNames.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다");
        }
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findMaxPositionCar();

        return cars.stream()
                .filter(car -> car.isDraw(maxPositionCar))
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
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
