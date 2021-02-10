package racingcar.domain.validation;

import racingcar.utils.exception.InvalidNameLengthException;
import racingcar.utils.exception.InvalidTextException;

import java.util.regex.Pattern;

public class NameValidation {
    private static final Pattern TEXT_PATTERN = Pattern.compile("^[a-zA-Z가-힣0-9]*$");

    private NameValidation() {
    }

    public static void validateName(String name, int maxLength) {
        isValidLength(name, maxLength);
        isValidText(name);
    }

    private static void isValidLength(String value, int maxLength) {
        if (value.length() <= 0 || value.length() > maxLength) {
            throw new InvalidNameLengthException(maxLength);
        }
    }

    private static void isValidText(String name) {
        if (!TEXT_PATTERN.matcher(name).matches()) {
            throw new InvalidTextException();
        }
    }
}
