package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String ORIGINAL_DELIMITER = "[,:]";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_INPUT_INDEX = 2;

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        return sum(toInts(split(input)));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            String customInput = matcher.group(CUSTOM_INPUT_INDEX);

            return customInput.split(customDelimiter);
        }

        return input.split(ORIGINAL_DELIMITER);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private static int sum(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            checkNegative(number);
            result += number;
        }

        return result;
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }
}
