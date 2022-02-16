package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.movement.MovementStrategy;

public class Cars {

    private static final int MIN_LENGTH = 0;
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(String names) {
        return new Cars(createCarsByName(names));
    }

    private static List<Car> createCarsByName(String names) {
        String[] carNames = splitByDelimiter(names);
        return createCarList(carNames);
    }

    private static String[] splitByDelimiter(String names) {
        String[] carNames = names.split(DELIMITER);
        if (carNames.length == MIN_LENGTH) {
            throw new IllegalArgumentException("자동차 이름에 "+ DELIMITER + "만 사용할 수 없습니다.");
        }
        return carNames;
    }

    private static List<Car> createCarList(String[] carNames) {
        return Arrays.stream(carNames)
            .map(name -> new Car(name.trim()))
            .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
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

    public void move(MovementStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }
}
