package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int INPUT_STRING_INDEX = 2;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String OR = "|";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (!isEmpty(input)) {
            return 0;
        }

        int[] numbers = Arrays.stream(split(input))
                .mapToInt(StringCalculator::parseIntegerOrThrow)
                .filter(StringCalculator::isPositiveIntegerOrThrow)
                .toArray();

        return sum(numbers);
    }

    private static String[] split(String input) {
        String delimeter = DEFAULT_DELIMITER;
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            delimeter = delimeter.concat(OR + matcher.group(CUSTOM_DELIMITER_INDEX));
            input = matcher.group(INPUT_STRING_INDEX);
        }
        return input.split(delimeter);
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce(0, Integer::sum);
    }

    private static boolean isEmpty(String input) {
        if (input == null || input.equals("")) {
            return false;
        }
        return true;
    }

    private static boolean isPositiveIntegerOrThrow(int number) {
        if (number < 0) {
            throw new RuntimeException("양수만 입력하세요.");
        }
        return true;
    }

    private static int parseIntegerOrThrow(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수가 아닌 입력입니다.");
        }
    }
}
