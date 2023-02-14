package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Cars {

    private static final int POWER_UPPER_BOUND_EXCLUSIVE = 10;
    private static final int CARS_DOES_NOT_EXIST = 0;

    private static final String DUPLICATE_CAR_NAME_ERROR = "자동차명은 중복되어선 안됩니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCarNames(cars);
        this.cars = cars;
    }

    private void validateDuplicateCarNames(List<Car> cars) {
        Set<Car> carsDuplicateRemove = new HashSet<>(cars);

        if (carsDuplicateRemove.size() != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR);
        }
    }

    public void moveAll(PowerGenerator powerGenerator) {
        cars.forEach(car -> moveEach(powerGenerator, car));
    }

    private void moveEach(PowerGenerator powerGenerator, Car car) {
        car.move(powerGenerator.generate(POWER_UPPER_BOUND_EXCLUSIVE));
    }

    public List<Car> getWinners() {
        int maxDistanceOfCars = getMaxDistanceOfCars();

        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistanceOfCars))
                .collect(toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    private int getMaxDistanceOfCars() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(CARS_DOES_NOT_EXIST);
    }

}
