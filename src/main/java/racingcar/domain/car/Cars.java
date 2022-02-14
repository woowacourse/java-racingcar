package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.movement.MovementStrategy;
import racingcar.exception.CarNamesNotOnlyCommaException;

public class Cars {

    private static final int MIN_LENGTH = 0;
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
        if (carNames.length == MIN_LENGTH) {
            throw new CarNamesNotOnlyCommaException("자동차 이름에 ,만 사용할 수 없습니다.");
        }
        return carNames;
    }

    private List<Car> createCarList(String... carNames) {
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        final int max = getMaxPosition();
        return cars.stream()
            .filter(car -> car.isSamePosition(max))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(-1);
    }

    public void move(MovementStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }
}
