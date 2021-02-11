package javaracingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName: carNames) {
            cars.add(new Car(carName));
        }
        validateNonZeroElement(cars);
        validateDistinctNames(cars);
    }

    // TODO: 테스트 하기 좋은 코드를 위해서는 Cars(List<Car> car) 생성자가 필요 -> 다양한 포지션의 Car객체를 생성하고 이를 테스트

    private void validateNonZeroElement(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
    }

    private void validateDistinctNames(List<Car> cars) {
        if (isDistinctNames(cars)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private boolean isDistinctNames(List<Car> cars) {
        return cars.stream()
                   .map(Car::getName)
                   .distinct()
                   .count() != cars.size();
    }

    public List<Car> toList() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                   .filter(car -> car.isAtPosition(maxPosition))
                   .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                   .mapToInt(Car::getPosition)
                   .max()
                   .orElseThrow(() -> new IllegalArgumentException("Max Position 구하는데에 실패했습니다."));
    }

    //TODO: Cars에 equals, hashCode를 정의해야 할까?
}
