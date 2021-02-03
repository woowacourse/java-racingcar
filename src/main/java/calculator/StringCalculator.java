package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String input) {

        if (input == null || input.equals("")) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            loop(tokens);
            return sum(tokens);
        }

        String[] numbers = input.split(",|:");
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
            throwIfNegative(number);
        }
    }

    public static void throwIfNegative(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}
