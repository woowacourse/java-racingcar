package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Cars {
    private static final String SAME_NAME_ERROR_MSG = "[ERROR] 중복된 이름이 있습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateSameName(cars);
        this.cars = new ArrayList<>(cars);
    }

    public static Cars createCars(List<Car> cars) {
        return createCars(cars);
    }

    public static Cars createCarsByNames(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(toList()));
    }

    private void validateSameName(List<Car> cars) {
        Set<String> sameNameChecker = cars.stream()
                .map(Car::getName)
                .map(Name::toString)
                .collect(toSet());

        if (sameNameChecker.size() < cars.size()) {
            throw new IllegalArgumentException(SAME_NAME_ERROR_MSG);
        }
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
    }

    public GameResult findWinners() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(collectingAndThen(toList(), GameResult::new));
    }

    private Position getMaxPosition() {
        return new Position(cars.stream()
                .map(Car::getPosition)
                .mapToInt(Position::index)
                .max()
                .orElseThrow(NoSuchElementException::new));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
