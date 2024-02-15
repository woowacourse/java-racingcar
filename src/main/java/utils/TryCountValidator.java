package utils;

public class TryCountValidator {
    private static final String format = "[1-9]\\d*";

    public static void validateTryCountFormat(String tryCountStr) {
        if (!tryCountStr.matches(format)) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야만 합니다.");
        }
    }
}
