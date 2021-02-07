package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.view.ErrorMessages;

public class ValidateUtils {

    private ValidateUtils() {
        throw new IllegalStateException("ValidateUtils is an utility class");
    }

    public static void validateCarName(String name) {
        validateMaxNameLength(name);
        validateNoName(name);
    }

    public static void validateUniqueCarNames(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_DUPLICATE_NAMES);
        }
    }

    public static int validateTurnQuantity(String userInput) {
        int parsedInt = validateNumeric(userInput);
        validatePositive(parsedInt);
        return parsedInt;
    }

    private static void validateMaxNameLength(String name) {
        if (name.length() > Car.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NAME_LENGTH);
        }
    }

    private static void validateNoName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NONAME);
        }
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
