package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static int number;
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String SPLIT_REGEX = ",|:";

    public static int splitAndSum(String text) throws RuntimeException {
        if (checkNullOrEmpty(text)) {
            return 0;
        }
        if ((number = parseByCustomDelimiter(text)) != -1) {
            return number;
        }
        if ((number = parseBySplitRegex(text)) != -1) {
            return number;
        }
        return parseSingleTextToInt(text);
    }

    private static int parseSingleTextToInt(String text) {
        return validateNegative(text);
    }

    private static boolean checkNullOrEmpty(String text) {
        return (text == null || text.isEmpty());
    }

    private static int parseByCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return addElements(tokens);
        }
        return -1;
    }

    private static int parseBySplitRegex(String text) {
        String[] numbers = text.split(SPLIT_REGEX);
        if (numbers.length >= 2) {
            return addElements(numbers);
        }
        return -1;
    }

    private static int addElements(String[] numbers) throws RuntimeException {
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            number += validateNegative(numbers[i]);
        }
        return number;
    }

    private static int validateNegative(String numberText) throws RuntimeException {
        int parsedNumber = Integer.parseInt(numberText);
        if (parsedNumber < 0) {
            throw new RuntimeException();
        }
        return parsedNumber;
    }

}
