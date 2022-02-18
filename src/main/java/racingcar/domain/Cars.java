package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarDto;

public class Cars {
    private static final String ERROR_CAR_EMPTY = "자동차가 존재하지 않습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(Names names) {
        return new Cars(names.getNames().stream()
                .map(Car::fromName)
                .collect(Collectors.toList()));
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public void driveAll(NumberGeneratePolicy numberGeneratePolicy) {
        cars.forEach(car -> car.drive(numberGeneratePolicy.generate()));
    }

    public List<CarDto> getWinners() {
        final Car maxPositionCar = findMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    public Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_CAR_EMPTY));
    }

    public List<CarDto> getCurrentCars() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
