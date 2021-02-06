package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int NUMBER_ZERO = 0;
    private static final int CUSTOM_DELIMITER = 1;
    private static final int NUMBERS = 2;
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    private static final Pattern cusomDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
    private static final Delimiters delimiters = new Delimiters();

    private StringCalculator() {
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return NUMBER_ZERO;
        }

        Matcher matchedPattern = cusomDelimiterPattern.matcher(text);
        if (matchedPattern.find()) {
            delimiters.addCustomDelimiters(matchedPattern.group(CUSTOM_DELIMITER));
            text = matchedPattern.group(NUMBERS);
        }
        return splitAndSumByDelimiters(text);
    }

    private static int splitAndSumByDelimiters(final String numbers) {
        int result = 0;
        for (String number : numbers.split(delimiters.toString())) {
            result += toValidNumber(number);
        }
        return result;
    }

    private static int toValidNumber(final String number) {
        try {
            return validatePositiveNumber(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static int validatePositiveNumber(String number) {
        int result = Integer.parseInt(number);
        if (result < NUMBER_ZERO) {
            throw new RuntimeException();
        }
        return result;
    }

}
