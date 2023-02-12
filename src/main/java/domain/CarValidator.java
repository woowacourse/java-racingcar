package domain;

import validation.ErrorMessage;

public class CarValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public static void validateCarName(String carName) {
        checkCarName(carName);
    }

    private static void checkCarName(String carName) {
        if (isWrongSizeName(carName) || isBlank(carName)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_NAME.getErrorMessage());
        }
    }

    private static boolean isWrongSizeName(String carName) {
        return carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH;
    }

    private static boolean isBlank(String carName) {
        return carName.isBlank();
    }
}
