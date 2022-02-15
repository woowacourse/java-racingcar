package racingcar.utils;

import racingcar.domain.Car;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarOutput;
import racingcar.validator.CarNameValidator;
import racingcar.validator.CarNamesValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsGenerator {
    private static final String NAME_DELIMITER = ",";

    public static List<Car> carNameInput() {
        String userInput = RacingCarInput.userCarNameInput();
        try {
            return CarsGenerator.generateCars(userInput);
        } catch (IllegalArgumentException e) {
            RacingCarOutput.printErrorMessage(e.getMessage());
            return carNameInput();
        }
    }

    public static List<Car> generateCars(final String userInput) {
        List<String> carNames = separateCarNames(userInput);
        CarNamesValidator.validate(carNames);
        carNames.forEach(CarNameValidator::validate);
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private static List<String> separateCarNames(final String userInput) {
        return Arrays.asList(userInput.split(NAME_DELIMITER, -1));
    }
}
