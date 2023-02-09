package validation;

public class TryCountValidation {

    private static final int BOUNDARY_NEGATIVE_VALUE = 0;

    public static void validateTryCount(int input) {
        if (input < BOUNDARY_NEGATIVE_VALUE) {
            throw new IllegalArgumentException("양수를 입력하세요.");
        }
    }
}
