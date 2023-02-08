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
    }

    public static void isNotEmpty(final String input) throws IllegalArgumentException {
        if (input.equals("")) {
            throwError(ErrorMessages.EMPTY_INPUT);
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
}