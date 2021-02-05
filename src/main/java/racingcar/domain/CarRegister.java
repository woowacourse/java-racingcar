package racingcar.domain;

import racingcar.exception.InvalidDuplicateCarNameException;
import racingcar.exception.InvalidNumberOfRegisteredCarsException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRegister {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INVALID_NUMBER_OF_CARS_ZERO = 0;

    public List<Car> registerCars(String input) {
        List<String> carNames = validateCarNames(input);

        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private List<String> validateCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());

        validateNumberOfRegisteredCars(carNames);
        validateDuplicateCarNames(carNames);

        return carNames;
    }

    private void validateNumberOfRegisteredCars(List<String> carNames) {
        if (carNames.size() == INVALID_NUMBER_OF_CARS_ZERO) {
            throw new InvalidNumberOfRegisteredCarsException();
        }
    }

    private void validateDuplicateCarNames(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new InvalidDuplicateCarNameException();
        }
    }
}
