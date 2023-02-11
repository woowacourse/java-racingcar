package validation;

public class TryCountValidation {

    private static final int MINIMUM_TRY_COUNT = 0;

    public static void validateTryCount(int input) {
        if (input < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("0 이상의 수를 입력해주세요.");
        }
    }
}
