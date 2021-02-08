package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String defaultSeparator = ",|:";
    private static final String separatorDelimiter = "|";

    public static int splitAndSum(String input) {
        if (isInvalidStringInput(input)) {
            return 0;
        }

        if (isOnlyNumber(input)) {
            return Integer.parseInt(input);
        }

        String[] dividedString = splitLine(input);
        int[] numbers = parseToIntegerArray(dividedString);
        checkNegativeValue(numbers);
        return addNums(numbers);
    }

    private static String[] splitLine(String line) {
        Matcher separatorMatcher = getSeparatorMatcher(line);
        if (separatorMatcher.find()) {
            String customSeparator = separatorDelimiter + separatorMatcher.group(1);
            line = separatorMatcher.group(2);
            return splitBySeparator(line, defaultSeparator + customSeparator);
        }

        return splitBySeparator(line, defaultSeparator);
    }

    private static boolean isInvalidStringInput(String input) {
        if (isNull(input)) {
            return true;
        }

        if (isEmpty(input)) {
            return true;
        }
        return false;
    }

    private static Matcher getSeparatorMatcher(String input) {
        return Pattern.compile("//(.+)\n(.*)").matcher(input);
    }

    private static boolean isNull(String input) {
        return input == null;
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

    private static int[] parseToIntegerArray(String[] strings) {
        return Arrays.stream(strings)
            .peek(s -> {
                if (!isOnlyNumber(s)) {
                    throw new RuntimeException();
                }
            })
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    private static void checkNegativeValue(int[] numbers) {
        Arrays.stream(numbers)
            .forEach(n -> {
                if (isNegativeNumber(n)) {
                    throw new RuntimeException();
                }
            });
    }

    private static int addNums(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}
