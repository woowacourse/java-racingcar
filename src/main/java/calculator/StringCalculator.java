package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);

            return m.group(TEXT_INDEX).split(customDelimiter);
        }

        return text.split("[,:]");
    }

    private static int sum(String[] tokens) {
        int result = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);

            validateNegative(number);
            result += number;
        }

        return result;
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
