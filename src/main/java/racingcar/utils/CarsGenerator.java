package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.validator.CarNameValidator;

public class CarsGenerator {
    private static final String NAME_DELIMITER = ",";

    private static List<String> separateCarNames(String userInput) {
        return Arrays.asList(userInput.split(NAME_DELIMITER, -1));
    }

    public static List<Car> generateCars(String userInput) {
        List<String> carNames = separateCarNames(userInput);
        carNames.forEach(CarNameValidator::validate);
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
