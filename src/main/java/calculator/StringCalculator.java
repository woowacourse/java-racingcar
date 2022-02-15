package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String PATTERN = "\\d+";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] separatedValues = split(input);
        return getSum(separatedValues);
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }

    private static int getSum(String[] separatedValues) {
        int sum = 0;
        for (String separatedValue : separatedValues) {
            checkNaturalNumber(separatedValue);
            sum += Integer.parseInt(separatedValue);
        }
        return sum;
    }

    private static void checkNaturalNumber(String target) {
        if (!Pattern.matches(PATTERN, target)){
            throw new RuntimeException();
        }
    }
}
