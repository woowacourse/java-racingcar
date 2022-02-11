package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_SEPARATORS = ",|:";

    public static int splitAndSum(String rawInput) {
        if (isNullOrEmpty(rawInput)) {
            return 0;
        }

        String separators = extractSeparators(rawInput);
        String[] operands = extractOperands(rawInput).split(separators);

        return sum(operands);
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static String extractSeparators(String rawInput) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(rawInput);
        if (customSeparatorExists(matcher)) {
            return getCustomSeparators(matcher);
        }
        return DEFAULT_SEPARATORS;
    }

    private static String extractOperands(String rawInput) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(rawInput);
        if (customSeparatorExists(matcher)) {
            return getOperands(matcher);
        }

        return rawInput;
    }

    private static boolean customSeparatorExists(Matcher matcher) {
        return matcher.find();
    }

    private static String getCustomSeparators(Matcher matcher) {
        String customSeparator = matcher.group(1);
        return DEFAULT_SEPARATORS + "|" + customSeparator;
    }

    private static String getOperands(Matcher matcher) {
        return matcher.group(2);
    }


    private static int sum(String[] operands) {
        int sum = 0;

        for (String operand : operands) {
            int num = toInt(operand);
            validateNotNegative(num);
            sum += num;
        }

        return sum;
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }

    private static void validateNotNegative(int integer) {
        if (integer < 0) {
            throw new RuntimeException("음수를 입력하면 안 됩니다.");
        }
    }
}
