package racingcar.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            throw new IllegalArgumentException("[ERROR] 구분자로 끝날 수 없습니다.");
        }
    }

    private void validateDuplicateName(final List<Car> cars) {
        if (cars.size() != Set.copyOf(cars).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
        }
    }

    public void go(final NumberGenerator generator) {
        cars.forEach(car -> car.go(generator.generate()));
    }

    public List<Car> findWinners() {
        final Car winnerCar = findWinner();

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerCar))
                .toList();
    }

    private Car findWinner() {
        return cars.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("[ERROR] 우승자를 찾을 수 없습니다."));
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(Car::copy)
                .toList();
    }
}
