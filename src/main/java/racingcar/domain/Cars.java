package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private static final String DUPLICATED = "[ERROR] 중복된 자동차 이름은 허용되지 않습니다.";

    private Set<Car> cars;

    public Cars(Set<Car> cars) {
        validateDuplication(cars);
        this.cars = cars;
    }

    public static Cars from(String[] names) {
        Set<Car> cars = new HashSet<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    public void move() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }

    public ExecutionResult generateExecutionResult() {
        return new ExecutionResult(this.cars);
    }

    public List<String> selectWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(c -> c.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void validateDuplication(Set<Car> cars) {
        Set<String> names = new HashSet<>();

        for (Car car : cars) {
            names.add(car.getName());
        }

        if (names.size() < cars.size()) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

}
