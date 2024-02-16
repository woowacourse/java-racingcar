package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
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
        cars.sort(Car::compareTo);
        Collections.reverse(cars);
        Car winner = cars.get(0);
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .toList();
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(Car::copy)
                .toList();
    }

    //TODO: 이 메서드 어떻게 테스트 하지?
    public void sort() {
        cars.sort(Car::compareTo);
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
