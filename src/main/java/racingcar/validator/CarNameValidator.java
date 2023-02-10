package racingcar.validator;

import java.util.regex.Pattern;

public class CarNameValidator {
    private static final Pattern STRING_PATTERN = Pattern.compile("(\\w)+");
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_FORMAT_ERROR_MESSAGE = "[ERROR] 자동차 이름은 문자와 숫자만 가능합니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 비어있는 자동차 이름이 존재합니다.";
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 다섯 글자 이하여야 합니다.";

    public static void validate(String carName) {
        validateInvalidValue(carName);
        validateHasBlank(carName);
        validateOverMaxNameLength(carName);
    }

    private static void validateInvalidValue(String carName) {
        if (!STRING_PATTERN.matcher(carName).matches()) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateHasBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateOverMaxNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
