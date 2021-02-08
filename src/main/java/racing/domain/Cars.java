package racing.domain;

import racing.dto.CarDto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private static final String INVALID_CAR_COUNTS = "게임 참가자는 최소 2명 이상이어야 합니다.";
    private static final int SPLIT_THRESHOLD = -1;
    private static final int MINIMUM_CAR_COUNTS = 2;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCarCounts(cars);
        this.cars = cars;
    }

    public static Cars generate(String carNames, MovingStrategy movingStrategy) {
        String[] splitCarNames = splitCarNames(carNames);
        List<Car> cars = Arrays.stream(splitCarNames)
                .map(name -> new Car(name, movingStrategy))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(DELIMITER, SPLIT_THRESHOLD);
    }

    private void validateCarCounts(List<Car> cars) {
        if (cars.size() < MINIMUM_CAR_COUNTS) {
            throw new IllegalArgumentException(INVALID_CAR_COUNTS);
        }
    }

    public void race() {
        cars.forEach(Car::move);
    }

    public List<String> findWinnerNames() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(IllegalStateException::new);
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
