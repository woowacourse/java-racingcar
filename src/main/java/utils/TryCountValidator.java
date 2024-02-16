package utils;

import java.util.regex.Pattern;

public class TryCountValidator {
    private static final String TRY_COUNT_RANGE_ERROR_MESSAGE = "시도 횟수는 양의 정수여야만 합니다.";
    private static final Pattern FORMAT = Pattern.compile("[1-9]\\d*");

    public static void validateTryCountFormat(String tryCount) {
        if (!FORMAT.matcher(tryCount).matches()) {
            throw new IllegalArgumentException(TRY_COUNT_RANGE_ERROR_MESSAGE);
        }
    }
}
