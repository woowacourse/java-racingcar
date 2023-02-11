package model;

import dto.CarDto;
import dto.WinnerCarDto;
import exception.DuplicateCarNameException;
import exception.WrongRangeMovableNumberException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.RacingNumberGenerator;

public class Cars {

    private static final String SEPARATOR = ",";
    private static final int MIN_INCLUSIVE_VALUE = 0;
    private static final int MAX_INCLUSIVE_VALUE = 9;

    private final List<Car> cars;

    public Cars(String inputNames) {
        String[] carsName = inputNames.split(SEPARATOR);
        List<Car> inputCars = Arrays.stream(carsName)
                .distinct()
                .map(Car::new)
                .collect(Collectors.toList());

        validateNameDuplication(carsName.length, inputCars.size());
        cars = inputCars;
    }

    private void validateNameDuplication(int nameSize, int carSize) {
        if (nameSize != carSize) {
            throw new DuplicateCarNameException();
        }
    }

    public void race(RacingNumberGenerator generator) {
        for (Car car : cars) {
            car.race(generateValidMovableValue(generator));
        }
    }

    private int generateValidMovableValue(RacingNumberGenerator generator) {
        int movableNumber = generator.generate();

        if (isValidMovableValueRange(movableNumber)) {
            throw new WrongRangeMovableNumberException();
        }
        return movableNumber;
    }

    private boolean isValidMovableValueRange(int movableValue) {
        return movableValue < MIN_INCLUSIVE_VALUE || movableValue > MAX_INCLUSIVE_VALUE;
    }

    public List<CarDto> getCarsDto() {
        return cars.stream()
                .map(Car::mapToCarDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<WinnerCarDto> processWinner() {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .orElse(null);

        return sortWinner(winner);
    }

    private List<WinnerCarDto> sortWinner(Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::mapToWinnerCarDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
