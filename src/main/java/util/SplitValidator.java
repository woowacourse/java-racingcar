package util;

public class SplitValidator {

    private SplitValidator() {}

    public static void validate(String input, String delimiter) {
        validateStartsOrEndsWithDelimiter(input, delimiter);
    }

    private static void validateStartsOrEndsWithDelimiter(String input, String delimiter) {
        if (input.startsWith(delimiter) || input.endsWith(delimiter)) {
            throw new IllegalArgumentException(String.format("입력은 구분자 %s로 시작하거나 끝날 수 없습니다.", delimiter));
        }
    }
}
