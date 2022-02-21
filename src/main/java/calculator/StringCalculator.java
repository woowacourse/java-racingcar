package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int INITIAL_SUM_VALUE = 0;
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_TEXT_GROUP = 2;

    public int calculate(String input) {
        if (isNullOrEmpty(input)) {
            return INITIAL_SUM_VALUE;
        }

        var splitTokens = split(input);
        var numbers = toInts(splitTokens);
        return sum(numbers);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] split(String input) {
        var delimiter = getDelimiter(input);
        return getText(input).split(delimiter);
    }

    private Matcher getMatcher(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
    }

    private String getText(String input) {
        Matcher m = getMatcher(input);
        if (m.find()) {
            return m.group(CUSTOM_TEXT_GROUP);
        }
        return input;
    }

    private String getDelimiter(String input) {
        Matcher m = getMatcher(input);
        if (m.find()) {
            return m.group(CUSTOM_DELIMITER_GROUP);
        }
        return DEFAULT_DELIMITER_REGEX;
    }

    private int[] toInts(String[] inputTokens) {
        int[] numberArray = new int[inputTokens.length];
        for (int i = 0; i < inputTokens.length; i++) {
            numberArray[i] = parseInt(inputTokens[i]);
        }
        return numberArray;
    }

    private int parseInt(String inputToken) {
        int value = Integer.parseInt(inputToken);
        if (value < 0) {
            throw new IllegalArgumentException("숫자는 양수 또는 0이여야 합니다.");
        }
        return value;
    }

    private int sum(int[] numbers) {
        int total = INITIAL_SUM_VALUE;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
