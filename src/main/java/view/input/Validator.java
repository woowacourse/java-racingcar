package view.input;

import java.util.List;

public class Validator {

    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;
    static final String ERROR_HEADER = "[ERROR] ";

    private static void throwError(ErrorMessages errorMessage) {
        throw new IllegalArgumentException(ERROR_HEADER + errorMessage.getContent());
    }

    public static void isProperCarNames(final List<String> carNames) throws IllegalArgumentException {
        isAllProperLength(carNames);
        isNotContainDelimiter(carNames);
    }

    public static void isNotEmpty(final String input) throws IllegalArgumentException {
        if (input == null || input.equals("")) {
            throwError(ErrorMessages.EMPTY_INPUT);
        }
    }

    public static void isProperCount(final String input) throws IllegalArgumentException {
        if (input == null || !input.matches("^[1-9]\\d{0,8}")) {
            throwError(ErrorMessages.NOT_PROPER_COUNT);
        }
    }

    private static void isProperLength(final String carName) throws IllegalArgumentException {
        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
            throwError(ErrorMessages.NOT_PROPER_CAR_NAME_LENGTH);
        }
    }

    private static void isAllProperLength(final List<String> carNames) throws IllegalArgumentException {
        carNames.forEach(Validator::isProperLength);
    }

    private static void isNotContainDelimiter(final List<String> carNames) {
        if (carNames.stream().anyMatch(carName -> carName.contains("-"))) {
            throwError(ErrorMessages.CONTAINS_DELIMITER);
        }
    }

}