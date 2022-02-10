package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static String PATTERN = "\\d+";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int sum = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] separatedValues = m.group(2).split(customDelimiter);
            return getSum(separatedValues, sum);
        }

        String[] separatedValues = input.split(",|:");
        return getSum(separatedValues, sum);
    }

    private static int getSum(String[] separatedValues, int sum) throws RuntimeException {
        for (String separatedValue : separatedValues) {
            checkNaturalNumber(separatedValue);
            sum += Integer.parseInt(separatedValue);
        }
        return sum;
    }

    private static void checkNaturalNumber(String target) throws RuntimeException {
        if (!Pattern.matches(PATTERN, target)){
            throw new RuntimeException();
        }
    }
}
