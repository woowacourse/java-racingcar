package racingcar.util;

public class StringValidator {
    public static void validateIsEmpty(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("문자열은 빈값이면 안됩니다.");
        }
    }
}
