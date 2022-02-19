package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.movestrategy.MovingStrategy;

public class Cars {

    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 5;
    private static final String ERROR_CAR_COUNT = "자동차는 2대 이상 5대 이하이어야 합니다.";
    private static final String ERROR_DUPLICATE_NAME = "중복된 이름입니다.";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateCarCount(cars);
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public static Cars fromNames(final List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public static Cars fromCars(final List<Car> cars) {
        return new Cars(cars);
    }

    private void validateCarCount(final List<Car> cars) {
        if (cars.size() > MAX_COUNT || cars.size() < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }

    private void validateDuplicateName(final List<Car> cars) {
        Set<String> tempNameSet = new HashSet<>();
        for (Car car : cars) {
            tempNameSet.add(car.getName());
        }

        if (tempNameSet.size() < cars.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    public void moveCarsForward(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.moveForward(movingStrategy.canMoveForward());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
