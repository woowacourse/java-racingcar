package racingcar.domain;

import static java.text.MessageFormat.format;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final int MINIMUM_CAR_SIZE = 1;
    private static final int MAXIMUM_CAR_SIZE = 100;
    private static final String DUPLICATE_CAR_NAME_MESSAGE = "입력된 이름 목록{0}: 자동차 이름은 중복될 수 없습니다.";
    private static final String INVALID_CAR_SIZE_MESSAGE =
            "입력된 자동차 개수[{0}]: 자동차는 " + MINIMUM_CAR_SIZE + "대 이상, " + MAXIMUM_CAR_SIZE + "대 이하만 경주 가능합니다.";

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        final List<Car> cars = generateCars(carNames);
        validate(cars, carNames);
        this.cars = cars;
    }

    private List<Car> generateCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validate(final List<Car> cars, final List<String> carNames) {
        if (isDuplicate(cars, carNames)) {
            throw new IllegalArgumentException(format(DUPLICATE_CAR_NAME_MESSAGE, cars));
        }
        if (hasSmallSize(cars.size()) || hasLargeSize(cars.size())) {
            throw new IllegalArgumentException(format(INVALID_CAR_SIZE_MESSAGE, cars.size()));
        }
    }

    private boolean isDuplicate(final List<Car> cars, final List<String> carNames) {
        final Set<Car> uniqueCars = new HashSet<>(cars);
        return uniqueCars.size() != carNames.size();
    }

    private boolean hasSmallSize(final int carSize) {
        return carSize < MINIMUM_CAR_SIZE;
    }

    private boolean hasLargeSize(final int carSize) {
        return MAXIMUM_CAR_SIZE < carSize;
    }

    public void move(final NumberGenerator strategy) {
        for (final Car car : cars) {
            car.move(strategy.generate());
        }
    }

    public List<String> findWinners() {
        final Car winner = findWinner();
        return findWinners(winner);
    }

    private Car findWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }

    private List<String> findWinners(final Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
