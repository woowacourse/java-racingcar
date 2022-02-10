package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        return getSum(input);
    }

    private static int getSum(String input) {
        int sum = 0;
        for (String token : split(input)) {
            int number = parse(token);
            isNegative(number);
            sum += number;
        }
        return sum;
    }

    private static int parse(String token) {
        if (isEmpty(token)) {
            return 0;
        }
        return Integer.parseInt(token);
    }

    private static void isNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String group = m.group(1);
            return m.group(2).split(group);
        }
        return input.split(",|:");
    }
}