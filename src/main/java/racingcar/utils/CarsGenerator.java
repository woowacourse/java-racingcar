package racingcar.utils;

import racingcar.validator.CarNameValidator;
import racingcar.validator.CarNamesValidator;

import java.util.Arrays;
import java.util.List;

public class CarsGenerator {
    private static final String NAME_DELIMITER = ",";

    public static List<String> checkCarNames(final String userInput) {
        List<String> carNames = CarsGenerator.separateCarNames(userInput);
        CarNamesValidator.validate(carNames);
        carNames.forEach(CarNameValidator::validate);
        return carNames;
    }

    private static List<String> separateCarNames(final String userInput) {
        return Arrays.asList(userInput.split(NAME_DELIMITER, -1));
    }
}
