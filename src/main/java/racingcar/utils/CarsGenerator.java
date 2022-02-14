package racingcar.utils;

import racingcar.domain.Car;
import racingcar.ui.RacingCarInput;
import racingcar.validator.CarNameValidator;

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
            System.out.println(e.getMessage());
            return carNameInput();
        }
    }

    public static List<Car> generateCars(String userInput) {
        List<String> carNames = separateCarNames(userInput);
        carNames.forEach(CarNameValidator::validate);
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private static List<String> separateCarNames(String userInput) {
        return Arrays.asList(userInput.split(NAME_DELIMITER, -1));
    }
}
