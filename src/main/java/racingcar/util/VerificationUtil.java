package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

import static racingcar.constant.ErrorMessage.*;

public class VerificationUtil {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private VerificationUtil() {
    }

    public static void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameSpace(carName);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(MORE_THAN_ONE_LETTER);
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
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
