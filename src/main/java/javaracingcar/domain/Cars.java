package javaracingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public static Cars createByName(List<String> carNames) {
        return new Cars(carNames.stream()
                                .map(Car::new)
                                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validateNonZeroElement(this.cars);
        validateDistinctNames(this.cars);
    }

    // TODO: 테스트 하기 좋은 코드를 위해서는 Cars(List<Car> car) 생성자가 필요 -> 다양한 포지션의 Car 객체를 생성하고 이를 테스트
    // static method 를 이용하는 것이 좋은 접근인가?
    // List<String> List<Car>를 각각 생성자로 생성할 때 문제 발생.
    // validate 의 위치는 어디서?

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

    public List<Car> atPosition(int position) {
        return cars.stream()
                   .filter(car -> car.isAtPosition(position))
                   .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                   .mapToInt(Car::getPosition)
                   .max()
                   .orElseThrow(() -> new IllegalArgumentException("Max Position 구하는데에 실패했습니다."));
    }
}
