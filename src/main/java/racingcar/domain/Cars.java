package racingcar.domain;

import racingcar.exception.DuplicateException;
import racingcar.util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;


import static racingcar.domain.Car.START_POSITION;
import static racingcar.enumType.ExceptionMessage.DUPLICATE_MESSAGE;

public class Cars {

    private static final int CAR_MOVE_STANDARD = 4;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = makeCars(carNames);
        return new Cars(cars);
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getRoundResults() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> pickWinners() {
        return this.cars.stream().filter(car -> Objects.equals(car.getPosition(), getMaxPosition())).collect(Collectors.toList());
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    private static List<Car> makeCars(List<String> carNames) {
        return carNames.stream().map(Car::of).collect(Collectors.toList());
    }


    private void validateDuplicateCarName(List<Car> cars) {
        int nonDuplicateCount = new HashSet<>(cars).size();
        if (cars.size() != nonDuplicateCount) {
            throw new DuplicateException(DUPLICATE_MESSAGE.getValue());
        }
    }

    private int getMaxPosition() {
        return this.cars.stream().mapToInt(car -> car.getPosition()).max().orElse(START_POSITION);
    }

}
