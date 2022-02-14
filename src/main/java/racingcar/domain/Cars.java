package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.numbergenerator.NumberGenerator;

public class Cars {

    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 5;
    private static final String ERROR_CAR_COUNT = "[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.";
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름입니다.";

    private final List<Car> cars;

    public Cars(final String[] names, final NumberGenerator numberGenerator) {
        validateCarCount(names);
        validateDuplicateName(names);

        this.cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, numberGenerator));
        }
    }

    private void validateCarCount(String[] names) {
        if (names.length > MAX_COUNT || names.length < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }

    private void validateDuplicateName(String[] names) {
        Set<String> tempNameSet = new HashSet<>();
        for (String name : names) {
            tempNameSet.add(name);
        }

        if (tempNameSet.size() < names.length) {
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
