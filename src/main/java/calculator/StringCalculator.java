package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String REGEX_SEP = "//(.)\n(.*)";
    private static final String REGEX_DIGIT = "\\d+";

    public static int splitAndSum(String text) {
        if (checkEmptyOrNullString(text)) {
            return 0;
        }

        String[] numbers = splitNumber(text);

        checkAllDigit(numbers);

        return sum(numbers);
    }

    private static String[] splitNumber(String text) {
        Matcher matcher = Pattern.compile(REGEX_SEP).matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return text.split(",|:");
    }

    private static boolean checkEmptyOrNullString(String text) {
        return text == null || text.isEmpty();
    }

    private static void checkAllDigit(String[] numbers) {
        if (!Arrays.stream(numbers).allMatch(n -> n.matches(REGEX_DIGIT))) {
            throw new RuntimeException();
        }
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
