package view;

import java.text.MessageFormat;
import java.util.List;

public class InputValidator {

    private static final String INVALID_NAME_MESSAGE = "차의 이름은 {0}자 이상 ~ {1}자 이하여야 합니다.";
    private static final int NAME_LENGTH_LOWER_BOUND = 1;
    private static final int NAME_LENGTH_UPPER_BOUND = 5;

    public void validateNames(final List<String> names) {
        for (String name : names) {
            validateName(name);
        }
    }

    private void validateName(final String name) {
        if (name.length() < NAME_LENGTH_LOWER_BOUND || name.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException(
                    MessageFormat.format(INVALID_NAME_MESSAGE, NAME_LENGTH_LOWER_BOUND, NAME_LENGTH_UPPER_BOUND)
            );
        }
    }
}
