package racingcar.domain.car;

import racingcar.domain.result.Result;
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
        List<Car> cars = Arrays.stream(inputCarNames.split(DELIMITER))
                .map(CarName::valueOf)
                .map(Car::of)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void tryToMoveCars(List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        cars.forEach(car -> car.tryToMove(iterator.next()));
    }

    public Result getResultOfCars() {
        List<Car> cars = this.cars.stream()
                .map(Car::getInstance)
                .collect(Collectors.toList());
        return Result.of(cars);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
