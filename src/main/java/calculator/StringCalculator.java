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
        if(text == null || text.isEmpty()){
            return NUMBER_ZERO;
        }

        Matcher matchedPattern = cusomDelimiterPattern.matcher(text);
        if (matchedPattern.find()) {
            delimiters.addCustomDelimiters(matchedPattern.group(CUSTOM_DELIMITER));
            text = matchedPattern.group(NUMBERS);
        }

        return splitAndSumByDelimiters(text);
    }

    private static int splitAndSumByDelimiters(final String text) {
        String[] numbers = text.split(delimiters.toString());
        return sumNumbers(numbers);
    }

    private static int sumNumbers(final String[] numbers) {
        int result = NUMBER_ZERO;

        for (String number : numbers) {
            result += new Number(number).getNumber();
        }

        return result;
    }
}
