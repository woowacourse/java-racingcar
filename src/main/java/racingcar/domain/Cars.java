package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.NumberGeneratePolicy;

public class Cars {
    private static final String ERROR_CAR_EMPTY = "자동차가 존재하지 않습니다.";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carsName) {
        return new Cars(carsName.stream()
            .map(carName -> new Car(carName))
            .collect(Collectors.toList()));
    }

    public void driveAll(NumberGeneratePolicy numberGeneratePolicy) {
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
