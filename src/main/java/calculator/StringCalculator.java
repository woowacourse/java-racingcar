package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] numbers = split(text);

        return sum(numbers);
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split("[,:]");
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }

        return total;
    }
}
