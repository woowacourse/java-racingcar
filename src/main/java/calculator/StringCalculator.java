package calculator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_SEPARATORS = ",:";
    public static final String KEY_OPERANDS = "OPERANDS";
    public static final String KEY_SEPARATORS = "SEPARATORS";

    public static int splitAndSum(String rawInput) {
        if (isNullOrEmpty(rawInput)) {
            return 0;
        }

        HashMap<String, String> inputMap = extractInputMap(rawInput);
        String[] operands = getSplitResult(inputMap);

        return sum(operands);
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static HashMap<String, String> extractInputMap(String rawInput) {
        HashMap<String, String> inputMap = setUpInputMap(rawInput);

        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(rawInput);
        if (matcher.find()) {
            inputMap.replace(KEY_SEPARATORS, getCustomSeparators(matcher));
            inputMap.replace(KEY_OPERANDS, getOperands(matcher));
        }

        return inputMap;
    }

    private static HashMap<String, String> setUpInputMap(String rawInput) {
        HashMap<String, String> inputMap = new HashMap<>();
        inputMap.put(KEY_SEPARATORS, toSeparatorRegexFormat(DEFAULT_SEPARATORS));
        inputMap.put(KEY_OPERANDS, rawInput);

        return inputMap;
    }

    private static String getCustomSeparators(Matcher matcher) {
        String customSeparator = matcher.group(1);
        return toSeparatorRegexFormat(DEFAULT_SEPARATORS + customSeparator);
    }

    private static String toSeparatorRegexFormat(String string) {
        return "[" + string + "]";
    }

    private static String getOperands(Matcher matcher) {
        return matcher.group(2);
    }

    private static String[] getSplitResult(HashMap<String, String> inputMap) {
        String separators = inputMap.get(KEY_SEPARATORS);
        String operands = inputMap.get(KEY_OPERANDS);

        return operands.split(separators);
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
