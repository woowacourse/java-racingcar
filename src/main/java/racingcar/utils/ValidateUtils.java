package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.Car;
import racingcar.view.ErrorMessages;

public class ValidateUtils {

    private ValidateUtils(){
    }

    public static void validateNames(List<Car> cars) {
        validateMaxNameLength(cars);
        validateNoName(cars);
        validateDuplicate(cars);
    }

    private static void validateMaxNameLength(List<Car> cars) {
        boolean exists = cars.stream()
                .anyMatch(car -> !Car.checkMaxName(car));
        if (exists) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NAME_LENGTH);
        }
    }

    private static void validateDuplicate(List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        boolean exists = cars.stream()
                .anyMatch(car -> !carNames.add(car.getName()));
        if (exists) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_DUPLICATE_NAMES);
        }
    }

    private static void validateNoName(List<Car> cars) {
        boolean exists = cars.stream()
                .anyMatch(car -> car.getName().length() == 0);
        if (exists) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NONAME);
        }
    }

    public static int validateTurnQuantity(String userInput) {
        int parsedInt = validateNumeric(userInput);
        validatePositive(parsedInt);
        return parsedInt;
    }

    private static int validateNumeric(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_TURN_NOT_INTEGER);
        }
    }

    private static void validatePositive(int parsedInt) {
        if (parsedInt <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_TURN_NOT_POSITIVE);
        }
    }
}
