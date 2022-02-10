package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int splitAndSum(String str) {
        int sum = 0;

        if (str == null || str.length() == 0) {
            return 0;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            sum = getSum (sum, tokens);

            return sum;
        }

        String[] tokens = str.split(",|:");

        sum = getSum (sum, tokens);

        return sum;
    }

    private static int getSum(int sum, String[] tokens) {
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
