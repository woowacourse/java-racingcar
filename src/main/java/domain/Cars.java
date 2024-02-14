package domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String INVALID_CARS_SIZE_EXCEPTION_MESSAGE = "게임에 참여하는 자동차의 수는 최소 %d대 이상이어야 합니다.";
    private static final String DUPLICATE_CAR_NAMES_EXCEPTION_MESSAGE = "게임에 참여하는 자동차들의 이름은 중복될 수 없습니다.";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MINIMUM_CARS_SIZE = 1;

    private final List<Car> cars;

    public Cars(String inputCarNames) {
        List<Car> cars = mapCar(inputCarNames);
        validateCars(cars);

        this.cars = cars;
    }

    private List<Car> mapCar(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    private void validateCars(List<Car> cars) {
        if (cars.size() < MINIMUM_CARS_SIZE) {
            throw new IllegalArgumentException(
                    String.format(INVALID_CARS_SIZE_EXCEPTION_MESSAGE, MINIMUM_CARS_SIZE));
        }

        if (hasDuplicateCarName(cars)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicateCarName(List<Car> cars) {
        return cars.size() != cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
    }

    public void moveCars(NumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator.generate()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
