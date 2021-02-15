package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String SEPARATOR_DELIMITER = "|";

    private static final int CUSTOM_DEFINITION_GROUP = 1;
    private static final int EXCEPT_CUSTOM_GROUP = 2;

    private static final Pattern COMPILED_PATTERN = Pattern.compile("//(.+)\n(.*)");

    public static int splitAndSum(String input) {
        if (isInvalidStringInput(input)) {
            return 0;
        }

        if (isOnlyNumber(input)) {
            return Integer.parseInt(input);
        }

        String[] dividedString = splitLine(input);
        List<Integer> numbers = parseToIntegerArray(dividedString);
        checkNegativeValue(numbers);
        return addNums(numbers);
    }

    private static String[] splitLine(String line) {
        Matcher separatorMatcher = getSeparatorMatcher(line);
        if (separatorMatcher.find()) {
            String customSeparator =
                SEPARATOR_DELIMITER + separatorMatcher.group(CUSTOM_DEFINITION_GROUP);
            line = separatorMatcher.group(EXCEPT_CUSTOM_GROUP);
            return splitBySeparator(line, DEFAULT_SEPARATOR + customSeparator);
        }

        return splitBySeparator(line, DEFAULT_SEPARATOR);
    }

    private static boolean isInvalidStringInput(String input) {
        if (Objects.isNull(input)) {
            return true;
        }

        return isEmpty(input);
    }

    private static Matcher getSeparatorMatcher(String input) {
        return COMPILED_PATTERN.matcher(input);
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isOnlyNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNegativeNumber(int num) {
        return num < 0;
    }

    private static String[] splitBySeparator(String input, String separator) {
        return input.split(separator);
    }

    private static List<Integer> parseToIntegerArray(String[] strings) {
        return Arrays.stream(strings)
            .filter(s -> {
                if (!isOnlyNumber(s)) {
                    throw new RuntimeException("숫자로만 이루어진 입력이 아닙니다.");
                }
                return true;
            })
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static void checkNegativeValue(List<Integer> numbers) {
        numbers.forEach(n -> {
            if (isNegativeNumber(n)) {
                throw new RuntimeException("음수는 정상적인 입력이 아닙니다.");
            }
        });
    }

    private static int addNums(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}
