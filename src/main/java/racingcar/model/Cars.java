package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import racingcar.message.ErrorMessage;

public class Cars {

    private static final String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(final Car... car) {
        final List<Car> value = new ArrayList<>(Arrays.asList(car));
        validateDuplicateName(value);
        this.cars = value;
    }

    private Cars(final List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public static Cars from(final String carsName) {
        validateSeparator(carsName);

        final List<Car> cars = Arrays.stream(carsName.split(SEPARATOR))
                .map(Car::from)
                .toList();

        return new Cars(cars);
    }

    private static void validateSeparator(final String carsName) {
        if (carsName.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.get());
        }
    }

    private void validateDuplicateName(final List<Car> cars) {
        if (cars.size() != Set.copyOf(cars).size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.get());
        }
    }

    public void go(final NumberGenerator generator) {
        cars.forEach(car -> car.go(generator));
    }

    public List<Car> findWinners() {
        Car winner = findWinner();
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .toList();
    }

    public Car findWinner() {
        return cars.stream()
                .reduce((car, car2) -> car.isWin(car2) ? car : car2)
                .orElseThrow();
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(Car::copy)
                .toList();
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
