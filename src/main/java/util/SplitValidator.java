package util;

public class SplitValidator {

    private SplitValidator() {}

    public static void validate(String input, String delimiter) {
        validateDelimiter(input, delimiter);
        validateEndsWithDelimiter(input, delimiter);
    }

    private static void validateDelimiter(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException(String.format("입력은 구분자 %s로 구분하여 입력해야 합니다.", delimiter));
        }
    }

    private static void validateEndsWithDelimiter(String input, String delimiter) {
        if (input.endsWith(delimiter)) {
            throw new IllegalArgumentException(String.format("입력은 구분자 %s로 끝날 수 없습니다.", delimiter));
        }
    }
}
