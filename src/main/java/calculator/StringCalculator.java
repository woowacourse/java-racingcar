package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    private static final Delimiters delimiters = new Delimiters();

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return ZERO;
        }

        Matcher matchedPattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matchedPattern.find()) {
            delimiters.addCustomDelimiters(matchedPattern.group(1));
            text = matchedPattern.group(2);
        }
        return splitAndSumByDelimiters(text);
    }

    private static int splitAndSumByDelimiters(String text) {
        String[] numbers = text.split(delimiters.getDelimiters());
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int result = 0;

        for (String numberText : numbers) {
            result += new Number(numberText).getNumber();
        }
        return result;
    }
}
