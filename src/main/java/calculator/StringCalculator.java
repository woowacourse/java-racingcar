package calculator;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {

    public static final String CUSTOM_SEPARATOR_PREFIX = "//";
    public static final char CUSTOM_SEPARATOR_SUFFIX = '\n';
    public static final String EMPTY_STRING = "";
    public static final String DEFAULT_SEPARATOR_REGEX = "[,:%s]";

    public int stringSum(String input) {
        if (isInputNullOrEmpty(input)) {
            return 0;
        }
        String[] numbers = splitBySeparator(input);
        return getSumNumbers(numbers);
    }

    private String[] splitBySeparator(String input) {
        return getTargetString(input).split(getSeparatorRegex(input));
    }

    private int getSumNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .peek(this::validatePositiveNumber)
                .sum();
    }

    private void validatePositiveNumber(Integer number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private String getTargetString(String input) {
        if (isCustomSeparatorExists(input)) {
            return input.substring(4);
        }
        return input;
    }

    private boolean isInputNullOrEmpty(String input) {
        return input == null || input.equals(EMPTY_STRING);
    }

    private boolean isCustomSeparatorExists(String input) {
        return input.startsWith(CUSTOM_SEPARATOR_PREFIX)
                && input.charAt(3) == CUSTOM_SEPARATOR_SUFFIX;
    }

    private String getSeparatorRegex(String input) {
        Optional<String> customSeparator = getCustomSeparator(input);

        if (!customSeparator.isPresent()) {
            return String.format(DEFAULT_SEPARATOR_REGEX, "");
        }
        return String.format(DEFAULT_SEPARATOR_REGEX, customSeparator.get());
    }

    private Optional<String> getCustomSeparator(String input) {
        if (isCustomSeparatorExists(input)) {
            return Optional.of(Character.toString(input.charAt(2)));
        }
        return Optional.empty();
    }
}
