package calculator;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String NOT_NUMBER_ERROR = "입력값은 숫자여야 합니다.";
    private static final String NEGATIVE_NUMBER_ERROR = "입력값은 자연수여야 합니다.";

    private static final String NORMAL_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(final String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private static String[] split(final String text) {
        final Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(NORMAL_DELIMITER);
    }

    private static List<Integer> toInts(final String[] values) {
        return Arrays.stream(values)
            .map(StringCalculator::toInt)
            .collect(toList());
    }

    private static int toInt(final String value) {
        validateNumber(value);
        return Integer.parseInt(value);
    }

    private static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_NUMBER_ERROR);
        }

        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_ERROR);
        }
    }

    private static int sum(final List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(number -> number)
            .sum();
    }
}
