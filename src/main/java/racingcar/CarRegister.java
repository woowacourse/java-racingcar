package racingcar;

import racingcar.exception.InvalidDuplicateCarNameException;
import racingcar.exception.InvalidNumberOfRegisteredCarsException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRegister {

    public List<Car> registerCars(String input) {
        List<String> carNames = validateCarNames(input);

        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private List<String> validateCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .collect(Collectors.toList());

        validateNumberOfRegisteredCars(carNames);
        validateDuplicateCarNames(carNames);

        return carNames;
    }

    private void validateNumberOfRegisteredCars(List<String> carNames) {
        if (carNames.size() == 0) {
            throw new InvalidNumberOfRegisteredCarsException();
        }
    }

    private void validateDuplicateCarNames(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new InvalidDuplicateCarNameException();
        }
    }
}
