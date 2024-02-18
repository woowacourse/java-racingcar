package view.validation;

import util.StringConvertor;

public class SplitValidator {
    private static final String DELIMITER = StringConvertor.getDelimiter();

    private SplitValidator() {
    }

    public static void validate(final String input) {
        validateDelimiter(input);
        validateEndsWithDelimiter(input);
    }

    private static void validateDelimiter(final String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(String.format("입력은 구분자 %s로 구분하여 입력해야 합니다.", DELIMITER));
        }
    }

    private static void validateEndsWithDelimiter(final String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(String.format("입력은 구분자 %s로 끝날 수 없습니다.", DELIMITER));
        }
    }
}
