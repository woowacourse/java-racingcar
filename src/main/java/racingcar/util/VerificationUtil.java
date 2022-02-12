package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

import static racingcar.constant.ErrorMessage.*;

public class VerificationUtil {

    private VerificationUtil() {
    }

    public static void validateCarName(String carName, int minLength, int maxLength) {
        validateEmptyCarName(carName);
        validateCarNameLength(carName, minLength, maxLength);
        validateCarNameSpace(carName);
    }

    private static void validateEmptyCarName(String carName) {
        if (carName == null || carName.length() == 0) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
    }

    private static void validateCarNameLength(String carName, int minLength, int maxLength) {
        if (carName.length() < minLength) {
            throw new IllegalArgumentException(MORE_THAN_ONE_LETTER);
        }

        if (carName.length() > maxLength) {
            throw new IllegalArgumentException(LESS_THAN_FIVE_LETTER);
        }
    }

    private static void validateCarNameSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(NO_SPACE);
        }
    }

    public static void validateDuplication(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(carNames));

        if (hashSet.size() < carNames.length) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    public static void validateAttempt(String attempt) {
        int number = validateInteger(attempt);
        validatePositiveNumber(number);
    }

    private static int validateInteger(String attempt) {
        try {
            return Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException(MUST_BE_INTEGER);
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE);
        }
    }
}
