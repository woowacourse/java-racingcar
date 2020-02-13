package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String BASIC_DELIMITER = ":|,";

    public static int plusByDelimiterFrom(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String customDelimiter = BASIC_DELIMITER;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            customDelimiter += "|" + m.group(1);
            String numbersWithDelimiters = m.group(2);
            return plus(numbersWithDelimiters, customDelimiter);
        }

        return plus(input, customDelimiter);
    }

    private static int plus(String customDelimiterAndNumber, String newDelimiter) {
        String valuesString = customDelimiterAndNumber;
        String[] values = valuesString.split(newDelimiter);

        int result = 0;
        for (String value : values) {
            result += parseInt(value);
        }
        return result;
    }

    private static int parseInt(String value) {
        int result = Integer.parseInt(value);
        if (result < 0) {
            throw new IllegalArgumentException();
        }
        return result;
    }

}
