package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.movement.MovementStrategy;
import racingcar.exception.InvalidNameInputException;

public class Cars {

    private static final int MINIMUM_CAR_QUANTITY = 0;
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String names) {
        this.cars = createCarsByName(names);
    }

    private List<Car> createCarsByName(String input) {
        String[] carNames = splitByDelimiter(input);
        return createCarList(carNames);

    }

    private String[] splitByDelimiter(String names) {
        String[] carNames = names.split(DELIMITER);
        if (carNames.length == MINIMUM_CAR_QUANTITY) {
            throw new InvalidNameInputException("입력된 자동차 목록이 유효하지 않습니다.");
        }
        return carNames;
    }

    private List<Car> createCarList(String... carNames) {
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move(MovementStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public List<Car> findWinners() {
        final int max = findMaxPosition();
        return cars.stream()
            .filter(car -> car.isSamePosition(max))
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(-1);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }
}
