package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String NGATIVE_SIGN = "-";
    public static final String DELIMITER = ",|:";
    private static Matcher matcher;

    public static int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (text.contains(NGATIVE_SIGN)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return splitAndSum(text);
    }

    private static int splitAndSum(String text) {
        matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return sum(tokens);
        }

        String[] numbers = text.split(DELIMITER);
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