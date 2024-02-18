package racingcar.domain;

import java.util.Collections;
import java.util.List;

public record Cars(List<Car> cars) {

    private static final String DUPLICATED_CAR_NAME = "중복된 자동차 이름이 존재합니다.";

    public Cars {
        validateUniqueCarNames(cars);
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
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int numberOfPower = numbersOfPower.get(i);
            car.goIfNumberOfPowerEnough(numberOfPower);
        }
    }

    public List<String> findCarNamesWithSameDistance(int distance) {
        return cars.stream()
                .filter(car -> car.isSameDistance(distance))
                .map(Car::getName)
                .toList();
    }

    public int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElse(0);
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}
