package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.NumberGeneratingStrategy;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private Cars(String[] carNames) {
        this(Arrays.stream(carNames)
                .map(Car::from)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static Cars fromString(String inputCarName) {
        String[] carNames = splitCarsName(inputCarName);
        validateDuplicatedName(carNames);

        return new Cars(carNames);
    }

    public static Cars fromList(List<Car> cars) {
        String[] carNames = cars.stream()
                .map(Car::getName)
                .toArray(String[]::new);
        validateDuplicatedName(carNames);

        return new Cars(new ArrayList<>(cars));
    }

    private static void validateDuplicatedName(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));
        if (set.size() != carNames.length) {
            throw new RuntimeException("중복된 이름이 존재함");
        }
    }

    private static String[] splitCarsName(String carsName) {
        return carsName.split(",", -1);
    }

    public void driveAll(NumberGeneratingStrategy numberGeneratingStrategy) {
        cars.forEach(car -> car.drive(numberGeneratingStrategy.generateNumber()));
    }

    public List<Car> getWinners() {
        Position maxPosition = getMaxPosition();

        return Collections.unmodifiableList(
                cars.stream()
                        .filter(car -> car.isSamePosition(maxPosition))
                        .collect(Collectors.toList()));
    }

    private Position getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new RuntimeException("포지션 값이 없음"))
                .getPosition();
    }
}
