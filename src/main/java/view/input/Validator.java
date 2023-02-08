package view.input;

import java.util.List;

public class Validator {

    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;
    private final static String ERROR_HEADER = "[ERROR] ";

    private static void throwError(ErrorMessages errorMessage) throws IllegalArgumentException {

        throw new IllegalArgumentException(ERROR_HEADER + errorMessage.getContent());
    }

    public static void isProperCarNames(final List<String> carNames) throws IllegalArgumentException {
        isEmpty(carNames);
        isAllProperLength(carNames);
    }

    private static void isEmpty(final List<String> carNames) throws IllegalArgumentException {
        if (carNames.size() == 0) {
            throwError(ErrorMessages.EMPTY_INPUT);
        }
    }

    private static void isProperLength(final String carName) {
        final int MIN = 1;
        final int MAX = 5;
        if (carName.length() < MIN || carName.length() > MAX) {
            throwError(ErrorMessages.NOT_PROPER_CAR_NAME_LENGTH);
            throw new IllegalArgumentException();
        }
    }

    private static void isAllProperLength(final List<String> carNames) throws IllegalArgumentException {
        carNames.forEach(Validator::isProperLength);
    }
}