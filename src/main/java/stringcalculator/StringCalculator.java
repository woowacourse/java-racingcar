package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int DEFAULT_RETURN_NUMBER = 0;
    private static final int GET_CUSTOM_DELIMITER = 1;
    private static final int GET_NUMBERS = 2;

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",:";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    private static Matcher matcher;

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return DEFAULT_RETURN_NUMBER;
        }
        getMatcher(input);
        return getSum(input);
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    private static int getSum(String input) {
        return Arrays.stream(convertStringArrToIntArr(split(input)))
                .sum();
    }

    private static int[] convertStringArrToIntArr(String[] arr) {
        return Arrays.stream(arr)
                .mapToInt(StringCalculator::convertStringToNaturalNumber)
                .toArray();
    }

    private static int convertStringToNaturalNumber(String string) {
        int converted = Integer.parseInt(string);
        if (converted < 0) {
            throw new RuntimeException();
        }
        return converted;
    }

    private static String[] split(String input) {
        if (matcher.find()) {
            return splitByCustomDelimiter(matcher.group(GET_NUMBERS));
        }
        return input.split(LEFT_BRACKET + DEFAULT_DELIMITER + RIGHT_BRACKET);
    }

    private static String[] splitByCustomDelimiter(String input) {
        return input.split(getCustomDelimiter());
    }

    private static String getCustomDelimiter() {
        return LEFT_BRACKET + matcher.group(GET_CUSTOM_DELIMITER) + DEFAULT_DELIMITER + RIGHT_BRACKET;
    }

    private static void getMatcher(String input) {
        matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
    }
}