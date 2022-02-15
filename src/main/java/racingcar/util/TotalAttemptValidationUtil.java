package racingcar.util;

public class TotalAttemptValidationUtil {

    private static final String MUST_BE_INTEGER = "[ERROR] 시도 횟수는 숫자만 허용됩니다.";
    private static final String MUST_BE_POSITIVE = "[ERROR] 1미만의 시도횟수는 허용되지 않습니다.";

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
