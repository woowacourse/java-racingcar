package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final String CUSTOM_DELIM_PREFIX = "//";
    private static final String DEFAULT_DELIM_REGEX = "[,:]";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (isBlankOrNull(input)) {
            return DEFAULT_VALUE;
        }

        return sum(getNumbersWithDelim(input));
    }

    private static boolean isBlankOrNull(String input) {
        return input == null || input.isEmpty();
    }

    static String[] getNumbersWithDelim(String input) {
        if (isCustomDelimiter(input)) {
            return getNumbersWithCustomDelim(input);
        }

        String[] numbers = input.split(DEFAULT_DELIM_REGEX);
        ValidationUtil.checkFormat(numbers);
        return numbers;
    }

    private static boolean isCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIM_PREFIX);
    }

    private static String[] getNumbersWithCustomDelim(String input) {
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            throw new RuntimeException("양식이 올바르지 않습니다.");
        }

        String customDelimiter = matcher.group(1); //커스텀 구분자는 첫 번째 그룹
        String[] numbers = matcher.group(2).split(customDelimiter); //사용자 입력값은 두 번째 그룹
        ValidationUtil.checkFormat(numbers);

        return numbers;
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
