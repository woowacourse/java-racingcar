package utils;

public class TryCountValidator {
    private static final String INVALID_FORMAT_ERROR_MESSAGE = "시도 횟수는 양의 정수여야만 합니다.";
    private static final String format = "[1-9]\\d*";

    public static void validateTryCountFormat(String invalidTryCount) {
        if (!invalidTryCount.matches(format)) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
    }
}
