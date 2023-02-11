package racingcar.domain;

import racingcar.domain.vo.CarStatus;
import racingcar.exception.DuplicateException;

import java.util.*;
import java.util.stream.Collectors;


import static racingcar.domain.Car.START_POSITION;
import static racingcar.enumType.ExceptionMessage.DUPLICATE_MESSAGE;

public class Cars {

    private final List<Car> cars;

    private Cars(List<String> carNames) {
        this.cars = makeCars(carNames);
        validateDuplicateCarName();
    }

    public static Cars of(List<String> carNames) {
        return new Cars(carNames);
    }

    public void move(List<Integer> moveConditionValues) {
        for (int i = 0; i < getNumberOfCars(); i++) {
            cars.get(i).move(moveConditionValues.get(i));
        }
    }

    public List<CarStatus> getRoundResults() {
        return cars.stream().map(Car::getCarStatus)
                .collect(Collectors.toList());
    }

    public List<Car> pickWinners() {
        return this.cars.stream()
                .filter(car -> Objects.equals(car.getCarStatus().getPosition(), getMaxPosition()))
                .collect(Collectors.toList());
    }

    public int getNumberOfCars() {
        return cars.size();
    }


    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream().map(Car::of).collect(Collectors.toList());
    }

    private void validateDuplicateCarName() {
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
