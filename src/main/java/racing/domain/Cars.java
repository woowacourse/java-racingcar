package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racing.util.MovableStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        validateDuplicate(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        Map<String, Long> nameCounts = cars.stream()
                .collect(Collectors.groupingBy(Car::getName, Collectors.counting()));
        boolean hasDuplicates = nameCounts.values().stream().anyMatch(count -> count > 1);
        if (hasDuplicates) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public void moveAll(MovableStrategy movableStrategy) {
        cars.stream()
                .filter(car -> movableStrategy.isMove())
                .forEach(Car::move);
    }

    public List<Car> findWinners() {
        reverseSort();
        return findCarsWithSamePosition(cars.get(0));
    }

    public void reverseSort() {
        Collections.sort(cars);
    }

    public List<Car> findCarsWithSamePosition(Car target) {
        return cars.stream().filter((car) -> car.isSame(target)).toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
