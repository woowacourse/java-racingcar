package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int CUSTOM_DELIMITER = 1;
    private static final int CALCULATION_FORMULA = 2;
    private static final String SPLIT_STANDARD = ",|:";
    private static final String PATTERN_REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_REGEX);

    public static int splitAndSum(String text) {
        if (checkEmptyOrNullString(text)) {
            return 0;
        }

        String[] numbers = splitNumber(text);

        checkAllDigit(numbers);

        return sum(numbers);
    }

    private static String[] splitNumber(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(CUSTOM_DELIMITER);
            return matcher.group(CALCULATION_FORMULA).split(delimiter);
        }
        return text.split(SPLIT_STANDARD);
    }

    private static boolean checkEmptyOrNullString(String text) {
        return text == null || text.isEmpty();
    }

    private static void checkAllDigit(String[] numbers) {
        boolean condition = Arrays.stream(numbers)
                .allMatch(n -> n.matches("\\d+"));

        if (!condition) {
            throw new RuntimeException();
        }
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
