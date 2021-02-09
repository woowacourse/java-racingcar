package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Cars {
    private static final String SAME_NAME_ERROR_MSG_FORMAT = "[ERROR] 중복된 이름이 있습니다 : %s";
    private static final String COMMA_AND_BLANK = ", ";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateSameName(cars);
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        return createCars(cars);
    }

    public static Cars createCarsByNames(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private void validateSameName(List<Car> cars) {
        List<String> sameNameList = new ArrayList<>();
        cars.stream()
                .map(Car::getName)
                .collect(groupingBy(Function.identity(), counting()))
                .forEach((name, count) -> {
                    if (count > 1) {
                        sameNameList.add(name);
                    }
                });
        if (sameNameList.size() > 0) {
            throw new IllegalArgumentException(String.format(SAME_NAME_ERROR_MSG_FORMAT, String.join(COMMA_AND_BLANK, sameNameList)));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
    }

    public GameResult findWinners() {
        Position maxPosition = getMaxPosition();
        return new GameResult(cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList()));
    }

    private Position getMaxPosition() {
        return new Position(cars.stream()
                .map(Car::getPosition)
                .mapToInt(Position::index)
                .max()
                .orElseThrow(NoSuchElementException::new));
    }
}
