package model;

import dto.CarDto;
import dto.WinnerCarDto;
import exception.WrongRangeMovableNumberException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.RacingNumberGenerator;

public class Cars {

    private static final int MIN_INCLUSIVE_VALUE = 0;
    private static final int MAX_INCLUSIVE_VALUE = 9;

    private final Set<Car> cars;

    public Cars(Set<Car> cars) {
        this.cars = cars;
    }

    public void race(RacingNumberGenerator generator) {
        cars.forEach(car -> car.race(generateValidMovableNumber(generator)));
    }

    private int generateValidMovableNumber(RacingNumberGenerator generator) {
        int movableNumber = generator.generate();

        if (isValidRangeMovableNumber(movableNumber)) {
            throw new WrongRangeMovableNumberException();
        }
        return movableNumber;
    }

    private boolean isValidRangeMovableNumber(int movableValue) {
        return movableValue < MIN_INCLUSIVE_VALUE || movableValue > MAX_INCLUSIVE_VALUE;
    }

    public List<CarDto> getCarsDto() {
        return cars.stream()
                .map(Car::mapToCarDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<WinnerCarDto> calculateWinners() {
        Car winner = Collections.max(cars, Car::compareTo);

        return sortWinner(winner);
    }

    private List<WinnerCarDto> sortWinner(Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::mapToWinnerCarDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
