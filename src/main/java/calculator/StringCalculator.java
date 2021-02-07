package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String SPLIT_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_FORMAT = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile(CUSTOM_DELIMITER_FORMAT);
    private static int result;

    private StringCalculator() {
    }

    public static int splitAndSum(String text) throws RuntimeException {
        result = 0;
        if (checkNullOrEmpty(text)) {
            return 0;
        }
        if (parseByCustomDelimiter(text) || parseBySplitRegex(text)) {
            return result;
        }
        return Integer.parseInt(text);
    }

    private static boolean checkNullOrEmpty(String text) {
        return (text == null || text.isEmpty());
    }

    private static boolean parseByCustomDelimiter(String text) {
        Matcher m = CUSTOM_DELIMITER.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            addElements(tokens);
            return true;
        }
        return false;
    }

    private static boolean parseBySplitRegex(String text) {
        String[] numbers = text.split(SPLIT_REGEX);
        if (numbers.length >= 2) {
            addElements(numbers);
            return true;
        }
        return false;
    }

    private static void addElements(String[] numbers) throws RuntimeException {
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            validateNegative(number);
            result += number;
        }
    }

    private static void validateNegative(int number) throws RuntimeException {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

}
