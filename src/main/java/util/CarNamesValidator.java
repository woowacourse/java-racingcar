package util;

import enums.Delimiter;
import java.util.regex.Pattern;

public class CarNamesValidator extends InputValidator {
    private static final Delimiter DEFAULT_DELIMITER = Delimiter.COMMA;
    private static final Pattern CAR_NAMES_PATTERN = Pattern.compile(DEFAULT_DELIMITER.getRegex());

    @Override
    void validateCustom(String input) {
        if (!CAR_NAMES_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(DEFAULT_DELIMITER.getErrorMessage());
        }
    }
}
