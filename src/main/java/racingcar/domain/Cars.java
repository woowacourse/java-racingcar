package racingcar.domain;

import racingcar.domain.vo.CarStatus;
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

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(isMove(numberGenerator.generate())));
    }

    public List<CarStatus> getRoundResults() {
        return cars.stream().map(Car::getCarStatus)
                .collect(Collectors.toList());
    }

    public List<Car> pickWinners() {
        return this.cars.stream()
                .filter(car -> Objects.equals(car.getPosition(), getMaxPosition()))
                .collect(Collectors.toList());
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    private boolean isMove(int moveConditionValue) {
        return moveConditionValue >= CAR_MOVE_STANDARD;
    }

    private void validateDuplicateCarName(List<Car> cars) {
        int nonDuplicateCount = new HashSet<>(cars).size();
        if (cars.size() != nonDuplicateCount) {
            throw new DuplicateException(DUPLICATE_MESSAGE.getValue());
        }
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .mapToInt(car -> car.getCarStatus().getPosition())
                .max().orElse(START_POSITION);
    }

}
