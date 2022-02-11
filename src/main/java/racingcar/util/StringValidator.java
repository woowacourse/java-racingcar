package racingcar.util;

import java.util.Arrays;

public class StringValidator {
    private static final String FORMAT_PATTERN = "[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]+";

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

    public static void validateFormat(String text) {
        if (!text.matches(FORMAT_PATTERN)) {
            throw new IllegalArgumentException("올바르지 않은 형식의 문자열입니다.");
        }
    }

    public static void validateDuplicated(String[] texts) {
        if (texts.length != Arrays.stream(texts).distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
