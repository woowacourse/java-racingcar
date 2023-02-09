package model;

import dto.CarDto;
import dto.WinnerCarDto;
import exception.DuplicateCarNameException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.RacingNumberGenerator;

public class Cars {

    private static final String SEPARATOR = ",";

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
        cars.forEach(car -> car.race(generator));
    }

    public List<CarDto> getCarsDto() {
        return cars.stream()
                .map(Car::mapToCarDto)
                .collect(Collectors.toList());
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
