package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return custom(text);
    }

    private static int custom(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(tokens);
        }
        String[] numbers = text.split(",|:");
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
