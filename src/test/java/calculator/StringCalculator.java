package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitAndGetNumbers(input);

        return sum(numbers);
    }

    private static String[] splitAndGetNumbers(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split("[,:]");
    }

    private static int sum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            validateNegativeNumber(num);
            sum += num;
        }
        return sum;
    }

    private static void validateNegativeNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("음수를 입력하시면 안 됩니다.");
        }
    }
}
