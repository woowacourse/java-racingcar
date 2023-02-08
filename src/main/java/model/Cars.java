package model;

import dto.CarDto;
import exception.DuplicateCarNameException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.RacingNumberGenerator;

public class Cars {

    private static final String SEPARATOR = ",";

    private final Set<Car> cars;

    public Cars(String inputNames) {
        String[] carNames = inputNames.split(SEPARATOR);
        Set<Car> inputCars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toSet());

        validateNameDuplication(carNames.length, inputCars.size());
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
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }
}
