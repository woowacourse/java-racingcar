package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "[ERROR] 동일한 이름이 있습니다.";

    private final List<Car> cars = new ArrayList<Car>();

    private Cars() {
    }

    public Cars(List<String> names) {
        validateDuplicateNames(names);
        createCars(names);
    }

    private void createCars(List<String> names) {
        names.stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    public static void validateDuplicateNames(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Cars copy() {
        Cars carsCopied = new Cars();
        cars.stream()
                .map(car -> new Car(car.getName(), car.getPosition()))
                .forEach(carsCopied.cars::add);

        return carsCopied;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}