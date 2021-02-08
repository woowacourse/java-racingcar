package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static int splitAndSum(String number) {
        if (isNullOrZero(number)) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(number);
        if (m.find()) {
            return isCustom(m);
        }
        return isDelimiterOrNumber(number);
    }

    private static boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private static int isCustom(Matcher m) {
        String customDelimiter = m.group(1);
        String[] tokens = m.group(2).split(customDelimiter);
        return addSplitNumbers(tokens);
    }

    private static int isDelimiterOrNumber(String number) {
        String[] numbers = number.split(",|:");
        return addSplitNumbers(numbers);
    }

    private static int addSplitNumbers(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += getNumber(token);
        }
        return sum;
    }

    private static int getNumber(String token) {
        if (!isNumber(token)) {
            throw new RuntimeException();
        }
        return Integer.parseInt(token);
    }

    private static boolean isNullOrZero(String number) {
        if (number == null || number.isEmpty()) {
            return true;
        }
        return false;
    }
}
