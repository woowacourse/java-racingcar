package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (isCustomDelimiter(input)) {
            Matcher matcher = pattern.matcher(input);
            return sum(getNumbersWithCustomDelim(matcher));
        }

        return sum(getNumbersWithDelim(input));
    }

    private static String[] getNumbersWithDelim(String input) {
        String[] numbers = input.split(",|:");
        ValidationUtil.checkFormat(numbers);
        return numbers;
    }

    private static boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static String[] getNumbersWithCustomDelim(Matcher matcher) {
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] numbers = matcher.group(2).split(customDelimiter);
            ValidationUtil.checkFormat(numbers);
            return numbers;
        }
        return null;
    }

    private static Integer sum(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
