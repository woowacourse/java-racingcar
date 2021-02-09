package racingcar.domain;

import racingcar.validator.CarsValidator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        CarsValidator.validate(cars);
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(String inputCarNames) {
        String[] carNames = inputCarNames.split(DELIMITER);
        List<Car> cars = Arrays.stream(carNames).map(Car::of).collect(Collectors.toList());
        return new Cars(cars);
    }

    public void tryToMoveCars(List<Integer> numbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).tryToMove(numbers.get(i));
        }
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(car -> car.isMaxPosition(getMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public Result getResultOfCars() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.cars) {
            cars.add(Car.of(car.getName(), car.getPosition()));
        }
        return Result.of(cars);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
