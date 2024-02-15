package utils;

public class InputValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void carNamesValidator(String carNames) {
        for (String carName : carNames.split(",")) {
            validateCarNameLength(carName);
        }
    }

    public static void tryNumberValidator(String number) {
        int validateNumber = validateNumber(number);
        validateNegativeNumber(validateNumber);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_LONG);
        }
    }

    private static int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }

    private static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }
}
