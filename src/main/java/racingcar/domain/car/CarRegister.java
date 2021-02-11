package racingcar.domain.car;

import racingcar.exception.InvalidDuplicateCarNameException;
import racingcar.exception.InvalidNumberOfRegisteredCarsException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarRegister {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INVALID_NUMBER_OF_CARS_ZERO = 0;

    public List<Car> registerCars(final String input) {
        final List<String> carName = validateCarNames(input);

        return carName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static List<String> validateCarNames(final String input) {
        final List<String> carNames = Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());

        validateNumberOfRegisteredCars(carNames);
        validateDuplicateCarNames(carNames);

        return carNames;
    }

    private static void validateNumberOfRegisteredCars(List<String> carNames) {
        if (carNames.size() == INVALID_NUMBER_OF_CARS_ZERO) {
            throw new InvalidNumberOfRegisteredCarsException();
        }
    }

    private static void validateDuplicateCarNames(List<String> carNames) {
        if (new HashSet<>(carNames).size() != carNames.size()) {
            throw new InvalidDuplicateCarNameException();
        }
    }
}
