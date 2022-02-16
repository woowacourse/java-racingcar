package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarDto;

public class Cars {
    private static final String ERROR_CAR_EMPTY = "자동차가 존재하지 않습니다.";
    public static final String ERROR_DUPLICATED_CAR_NAME_MESSAGE = "중복값을 입력할 수 없습니다.";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> carNames) {
        validateCarNames(carNames);
        return new Cars(carNames.stream()
                .map(carName -> Car.fromName(carName))
                .collect(Collectors.toList()));
    }

    public static Cars from(List<Car> cars) {
        validateCarNames(getCarNames(cars));
        return new Cars(cars);
    }

    private static void validateCarNames(List<String> carNames) {
        checkCarNamesDuplicated(carNames);
    }

    private static List<String> getCarNames(List<Car> cars) {
        return cars.stream().map(car -> car.toString()).collect(Collectors.toList());
    }

    private static void checkCarNamesDuplicated(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_CAR_NAME_MESSAGE);
        }
    }

    public void driveAll(NumberGeneratePolicy numberGeneratePolicy) {
        cars.forEach(car -> car.drive(numberGeneratePolicy.generateNumber()));
    }

    public List<CarDto> getWinners() {
        final Car maxPositionCar = findMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(car -> CarDto.from(car))
                .collect(Collectors.toList());
    }

    public Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_CAR_EMPTY));
    }

    public List<CarDto> getCurrentCars() {
        return cars.stream()
                .map(car -> CarDto.from(car))
                .collect(Collectors.toList());
    }
}
