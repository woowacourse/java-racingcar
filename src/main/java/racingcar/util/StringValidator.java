package racingcar.util;

public class StringValidator {
    public static void validateIsEmpty(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("문자열은 빈값이면 안됩니다.");
        }
    }

    public static void validateLength(String text, int min, int max) {
        if (text.length() < min || text.length() > max) {
            throw new IllegalArgumentException(
                    String.format("문자열의 길이가 %d 이상 %d 이하가 아닙니다.", min, max)
            );
        }
    }

    public static void validateFormatByRegex(String text, String regex) {
        if (!text.matches(regex)) {
            throw new IllegalArgumentException("올바르지 않은 형식의 문자열입니다.");
        }
    }
}
