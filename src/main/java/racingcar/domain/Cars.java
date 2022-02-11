package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names, MovingPolicy movingPolicy) {
        validateDuplicate(names);
        this.cars = Arrays.stream(names)
            .map(name -> new Car(name, movingPolicy))
            .collect(toList());
    }

    private void validateDuplicate(String[] names) {
        int originalSize = names.length;
        Set<String> noneDuplicatedNames = Arrays.stream(names).collect(toSet());
        if (originalSize != noneDuplicatedNames.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> maxPosition == car.getPosition())
            .map(Car::getName)
            .collect(toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
