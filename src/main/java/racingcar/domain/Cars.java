package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String ERROR_CAR_EMPTY = "자동차가 존재하지 않습니다.";
    private static final String ERROR_CARS_INVALID_DUPLICATED = "자동차들은 중복된 이름을 가질 수 없습니다.";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateDuplicated(cars);
        this.cars = cars;
    }

    private void validateDuplicated(final List<Car> cars) {
        Set<Car> carsSet = new HashSet<>(cars);
        if (carsSet.size() != cars.size()) {
            throw new IllegalArgumentException(ERROR_CARS_INVALID_DUPLICATED);
        }
    }

    public static Cars from(final List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars fromNames(final List<String> carsName) {
        return new Cars(carsName.stream()
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public void driveAll(final NumberGeneratePolicy numberGeneratePolicy) {
        cars.forEach(car -> car.drive(numberGeneratePolicy.generateNumber()));
    }

    public List<Car> getWinners() {
        final Car maxPositionCar = findMaxPositionCar();
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPositionCar))
            .collect(Collectors.toList());
    }

    public Car findMaxPositionCar() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow(() -> new IllegalArgumentException(ERROR_CAR_EMPTY));
    }

    public List<Car> getDriveRecord() {
        return Collections.unmodifiableList(cars);
    }
}
