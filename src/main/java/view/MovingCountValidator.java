package view;

public class MovingCountValidator {
    private static final int TRY_COUNT_MIN_RANGE = 1;
    private static final int TRY_COUNT_MAX_RANGE = 100;
    private static final String INPUT_INVALIDATE_MESSAGE = String.format("시도횟수는 %d~%d 범위의 숫자만 가능합니다.", TRY_COUNT_MIN_RANGE, TRY_COUNT_MAX_RANGE);

    public static void validateTryCountInput(String tryCount) {
        validateIsDigit(tryCount);
        validateTryCountRange(Integer.parseInt(tryCount));
    }

    private static void validateIsDigit(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_INVALIDATE_MESSAGE);
        }

    }

    private static void validateTryCountRange(int tryCount) {
        if (tryCount < TRY_COUNT_MIN_RANGE || tryCount > TRY_COUNT_MAX_RANGE) {
            throw new IllegalArgumentException(INPUT_INVALIDATE_MESSAGE);
        }
    }
}
