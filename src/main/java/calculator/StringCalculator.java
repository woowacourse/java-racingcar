package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String MINUS = "-";

    public static int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (text.contains(MINUS)) {
            throw new RuntimeException("잘못 입력하셨습니다.");
        }
        return splitAndSum(text);
    }

    private static int splitAndSum(String text) {
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