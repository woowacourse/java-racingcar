package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "[ERROR] 동일한 이름이 있습니다.";

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicate(names);
        this.cars = createCars(names);
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    //TODO
    // 예외 검증 Test 짜기
    private void validateDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}