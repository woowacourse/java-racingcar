package racingcar.domain;

import java.util.Collections;
import java.util.List;

public record Cars(List<Car> values) {

    private static final String DUPLICATED_CAR_NAME = "중복된 자동차 이름이 존재합니다.";

    public Cars {
        validateUniqueCarNames(values);
    }

    private void validateUniqueCarNames(List<Car> cars) {
        int uniqueCarNamesCount = (int) cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCarNamesCount != cars.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }
    }

    public void raceWithNumbersOfPower(List<Integer> numbersOfPower) {
        for (int i = 0; i < values.size(); i++) {
            Car car = values.get(i);
            int numberOfPower = numbersOfPower.get(i);
            car.goIfNumberOfPowerEnough(numberOfPower);
        }
    }

    public List<String> findCarNamesWithSameDistance(int distance) {
        return values.stream()
                .filter(car -> car.isSameDistance(distance))
                .map(Car::getName)
                .toList();
    }

    public int findMaxDistance() {
        return values.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElse(0);
    }

    public int valuesSize() {
        return values.size();
    }

    @Override
    public List<Car> values() {
        return Collections.unmodifiableList(values);
    }
}
