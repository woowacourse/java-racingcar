package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.validator.CarsValidator;

public class Cars {
    private final List<Car> cars;
    private int winnerPosition = 0;

    private Cars(final List<Car> cars) {
        CarsValidator.checkIsValidCars(cars);
        this.cars = cars;
    }

    public static Cars createByNames(final Name[] names) {
        return new Cars(Arrays.stream(names)
                .map(Car::createByName)
                .collect(Collectors.toList()));
    }

    public void tryMoveCars() {
        this.cars.forEach(Car::tryToMove);
        updateWinnerPosition();
    }

    private void updateWinnerPosition() {
        this.cars.forEach(car -> winnerPosition
                = Math.max(winnerPosition, car.getPosition()));
    }

    public String[] getWinners() {
        return this.cars.stream()
                .filter(car -> car.isInWinnerPosition(winnerPosition))
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public String getAllCarsPosition() {
        return this.cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    // XXX :: 테스트만을 위한 메소드
    public boolean contains(Car car) {
        return this.cars.contains(car);
    }
}
