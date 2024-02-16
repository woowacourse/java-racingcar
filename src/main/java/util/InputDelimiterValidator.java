package util;

import enums.Delimiter;
import java.util.regex.Pattern;

public class InputDelimiterValidator extends InputValidator {
    private static final Delimiter DEFAULT_DELIMITER = Delimiter.COMMA;
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(DEFAULT_DELIMITER.getRegex());

    @Override
    void validateCustom(String input) {
        if (!DELIMITER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(DEFAULT_DELIMITER.getErrorMessage());
        }
    }
}
