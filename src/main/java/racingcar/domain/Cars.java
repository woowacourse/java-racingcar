package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.movestrategy.MoveStrategy;

public class Cars {

    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 5;
    private static final String ERROR_CAR_COUNT = "[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.";
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름입니다.";

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCarCount(cars.size());
        validateDuplicateName(cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList()));
        this.cars = cars;
    }

    public Cars(final List<String> names, final MoveStrategy strategy) {
        validateCarCount(names.size());
        validateDuplicateName(names);

        this.cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, strategy));
        }
    }

    private void validateCarCount(final int size) {
        if (size > MAX_COUNT || size < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }

    private void validateDuplicateName(final List<String> names) {
        Set<String> tempNameSet = new HashSet<>();
        for (String name : names) {
            tempNameSet.add(name);
        }

        if (tempNameSet.size() < names.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.goForward();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car + "\n");
        }
        return stringBuilder.toString();
    }
}
