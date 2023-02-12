package racingcar.view;

import static java.text.MessageFormat.format;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_COUNT = 1;
    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String INVALID_NAME_MESSAGE =
            "입력된 차 이름[{0}]: 차의 이름은 " + MINIMUM_NAME_LENGTH + "자 이상 ~ " + MAXIMUM_NAME_LENGTH + "자 이하여야 합니다.";
    private static final String INVALID_COUNT_MESSAGE =
            "입력된 횟수[{0}]: 횟수는 " + MINIMUM_COUNT + "이상의 정수만 가능합니다.";


    public List<String> validateNames(final String input) {
        final List<String> names = generateNames(input);
        for (final String name : names) {
            validateName(name);
        }
        return names;
    }

    private List<String> generateNames(final String input) {
        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateName(final String name) {
        if (hasShortLength(name) || hasLongLength(name)) {
            throw new IllegalArgumentException(format(INVALID_NAME_MESSAGE, name));
        }
    }

    private boolean hasShortLength(final String name) {
        return name.length() < MINIMUM_NAME_LENGTH;
    }

    private boolean hasLongLength(final String name) {
        return MAXIMUM_NAME_LENGTH < name.length();
    }

    public int validateCount(final String input) {
        final int number = parseNumber(input);
        validateNumber(number);
        return number;
    }

    private int parseNumber(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(format(INVALID_COUNT_MESSAGE, input));
        }
    }

    private void validateNumber(final int number) {
        if (isZeroOrNegative(number)) {
            throw new IllegalArgumentException(format(INVALID_COUNT_MESSAGE, number));
        }
    }

    private boolean isZeroOrNegative(final int number) {
        return number < MINIMUM_COUNT;
    }
}
