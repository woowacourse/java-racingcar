package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String INVALID_CARS_SIZE_EXCEPTION_MESSAGE = "게임에 참여하는 자동차의 수는 최소 %d대 이상이어야 합니다.";
    private static final String DUPLICATE_CAR_NAMES_EXCEPTION_MESSAGE = "게임에 참여하는 자동차들의 이름은 중복될 수 없습니다.";
    private static final String EMPTY_CARS_EXCEPTION_MESSAGE = "차량 리스트가 비어있습니다.";
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

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> findCarsAtMaxPosition() {
        int maxPosition = findMaxPosition();
        return findCarsByPosition(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_CARS_EXCEPTION_MESSAGE));
    }

    private List<Car> findCarsByPosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isPositionEqualTo(maxPosition))
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
