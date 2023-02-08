package validation;

public class TryCountValidation {

    public static void validateTryCount(int input) {
        if(input < 0) {
            throw new IllegalArgumentException("양수를 입력하세요.");
        }
    }
}
