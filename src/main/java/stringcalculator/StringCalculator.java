package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final String NEGATIVE_ERROR_MESSAGE = "음수를 입력할 수 없습니다.";

    public static int splitAndSum(String input) {
        return calculate(castStringToInts(input));
    }

    private static int calculate(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] castStringToInts(String input) {
        if (isNullOrEmpty(input)) {
            return new int[]{0};
        }
        Matcher matcher = getCustomSeparatorMatcher(input);
        if (matcher.find()) {
            return separate(matcher.group(2), matcher.group(1));
        }
        return separate(input, ":|,");
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int[] separate(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .mapToInt(string -> Integer.parseInt(string))
                .peek(number -> validatePositive(number))
                .toArray();
    }

    private static Matcher getCustomSeparatorMatcher(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX);
        return pattern.matcher(input);
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_ERROR_MESSAGE);
        }
    }
}
