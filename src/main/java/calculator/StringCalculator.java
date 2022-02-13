package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String ORIGINAL_DELIMITER = "[,:]";
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int CUSTOM_INPUT_INDEX = 2;

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return sum(split(input));
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            String customInput = matcher.group(CUSTOM_INPUT_INDEX);

            return customInput.split(customDelimiter);
        }

        return input.split(ORIGINAL_DELIMITER);
    }

    private static int sum(String[] values) {
        int result = 0;

        for (String value : values) {
            int number = Integer.parseInt(value);
            checkNegative(number);
            result += number;
        }

        return result;
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
