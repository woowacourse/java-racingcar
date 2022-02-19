package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.movement.MovementStrategy;

public class Cars {

    private static final int DEFAULT_MAX_POSITION = -1;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(String[] names) {
        return new Cars(createCars(names));
    }

    private static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
            .map(name -> new Car(name.trim()))
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        final int max = findMaxPosition();
        return cars.stream()
            .filter(car -> car.isSamePosition(max))
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(DEFAULT_MAX_POSITION);
    }

    public void move(MovementStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }
}
