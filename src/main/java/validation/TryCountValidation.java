package validation;

public class TryCountValidation {

    private static final int MINIMUM_TRY_COUNT = 2;
    private static final int MAXIMUM_TRY_COUNT = 10;

    public static void validateTryCount(int input) {
        validatePermittedCount(input);
    }

    private static void validatePermittedCount(int input) {
        if (input < MINIMUM_TRY_COUNT || input > MAXIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("2 이상, 10 이하의 수를 입력해주세요.");
        }
    }
}
