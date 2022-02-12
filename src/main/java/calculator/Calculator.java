package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final String STANDARD_SPLIT_REGEX = "[,:]";
    private static final int DELIMITER_INDEX = 1;
    private static final int INPUT_INDEX = 2;

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        return getSum(split(input));
    }

    private static int getSum(String[] inputs) {
        int sum = 0;

        for (String input : inputs) {
            int number = parse(input);
            checkNegative(number);
            sum += number;
        }
        return sum;
    }

    private static int parse(String token) {
        if (isEmpty(token)) {
            return 0;
        }
        return Integer.parseInt(token);
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = getMatcher(input);
        if (isCustom(matcher)) {
            String delimiter = matcher.group(DELIMITER_INDEX);
            return matcher.group(INPUT_INDEX).split(delimiter);
        }
        return input.split(STANDARD_SPLIT_REGEX);
    }

    private static Matcher getMatcher(String input) {
        return Pattern.compile(CUSTOM_REGEX).matcher(input);
    }

    private static boolean isCustom(Matcher m) {
        return m.find();
    }
}
