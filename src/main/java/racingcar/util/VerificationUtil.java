package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

import static racingcar.constant.ErrorMessage.*;

public class VerificationUtil {

    private VerificationUtil() {
    }

    public static void validateCarName(String carName, int minLength, int maxLength) {
        isEmpty(carName);
        doesContainSpace(carName);
        isValidLength(carName, minLength, maxLength);
    }

    private static void isEmpty(String carName) {
        if (carName == null || carName.length() == 0) {
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

    public static void isDuplicated(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(carNames));

        if (hashSet.size() < carNames.length) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    public static void validateAttempt(String attempt) {
        int num = isInteger(attempt);
        isPositive(num);
    }

    private static int isInteger(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(MUST_BE_INTEGER);
        }
    }

    private static void isPositive(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE);
        }
    }
}
