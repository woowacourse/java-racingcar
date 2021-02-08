package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            delimiter += "|" + matcher.group(1);
            return calculate(matcher.group(2), delimiter);
        }
        return calculate(input, delimiter);
    }

    public static int calculate(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        loop(numbers);
        return sum(numbers);
    }

    public static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    public static void loop(String[] numbers) {
        for (String number : numbers) {
            throwExceptionIfNegative(number);
        }
    }

    public static void throwExceptionIfNegative(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}
