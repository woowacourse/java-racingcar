package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text.contains(",") || text.contains(":")) {
            String[] numbers = text.split("[,:]");

            return sum(numbers);
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] numbers = matcher.group(2).split(customDelimiter);

            return sum(numbers);
        }

        return 0;
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }

        return total;
    }


}
