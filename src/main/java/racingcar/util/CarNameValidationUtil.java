package racingcar.util;

import static racingcar.constant.ErrorMessage.*;

public class CarNameValidationUtil {

    private CarNameValidationUtil() {
    }

    public static void validateCarName(String carName, int minLength, int maxLength) {
        isEmpty(carName);
        doesContainSpace(carName);
        isValidLength(carName, minLength, maxLength);
    }

    private static void isEmpty(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
    }

    private static void doesContainSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(NO_SPACE);
        }
    }

    private static void isValidLength(String carName, int minLength, int maxLength) {
        if (carName.length() < minLength) {
            throw new IllegalArgumentException(MORE_THAN_ONE_LETTER);
        }

        if (carName.length() > maxLength) {
            throw new IllegalArgumentException(LESS_THAN_FIVE_LETTER);
        }
    }
}
