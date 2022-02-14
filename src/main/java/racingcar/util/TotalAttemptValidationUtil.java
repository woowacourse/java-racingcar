package racingcar.util;

import static racingcar.constant.ErrorMessage.MUST_BE_INTEGER;
import static racingcar.constant.ErrorMessage.MUST_BE_POSITIVE;

public class TotalAttemptValidationUtil {

    private TotalAttemptValidationUtil() {
    }

    public static void validateAttempt(String attempt) {
        int num = isIntegerThenParse(attempt);
        isPositive(num);
    }

    private static int isIntegerThenParse(String num) {
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
