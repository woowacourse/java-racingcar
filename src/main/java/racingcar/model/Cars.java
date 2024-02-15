package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.message.ErrorMessage;

public class Cars {

    private static final String SEPARATOR = ",";
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public static Cars from(final String carsName) {
        validateSeparator(carsName);

        final List<Car> cars = Arrays.stream(carsName.split(SEPARATOR))
                .map(Car::from)
                .collect(Collectors.toList());

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
        cars.forEach(car -> car.go(generator.generate()));
    }

    public List<Car> findWinner() {
        final int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(Car::copy)
                .toList();
    }
}
