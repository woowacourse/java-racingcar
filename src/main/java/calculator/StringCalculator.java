package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String CUSTOM_FINDER = "\n";
    private static final int CUSTOM_REGEX_INDEX = 0;
    private static final int CUSTOM_VALUES_INDEX = 1;
    private static final String NOT_VALID_DELIMITER = "올바르지 않은 구분자 입력입니다.";
    private static final String NO_NUMBER_AS_DELIMITER = "구분자로 숫자를 사용할 수 없습니다.";
    private static final String NOT_VALID_RANGE = "입력값은 0 이상이어야 합니다.";
    private static final int DELIMITER_INDEX = 2;
    private static final String CUSTOM_START = "//";
    private static final String REGEX_CUSTOM = "[/]{2}.";
    private static final String DEFAULT_REGEX = ",|:";

    public static int splitAndSum(String text) {
        if (isSlashExist(text)) {
            String[] customSplit = text.split(CUSTOM_FINDER);
            String customDelimiter = getCustomDelimiter(customSplit);

            return getTotal(customSplit[CUSTOM_VALUES_INDEX]
                    .split(getDelimiter(customDelimiter)));
        }
        return getTotal(text.split(DEFAULT_REGEX));
    }

    private static boolean isSlashExist(String text) {
        return text.startsWith(CUSTOM_START);
    }

    private static String getCustomDelimiter(String[] customSplit) {
        String customDelimiter = customSplit[CUSTOM_REGEX_INDEX];
        validateRightCustomDelimiter(customDelimiter);
        validateDelimiterNotNumber(customDelimiter);
        return customDelimiter;
    }

    private static void validateRightCustomDelimiter(String customDelimiter) {
        if (!Pattern.matches(REGEX_CUSTOM, customDelimiter)) {
            throw new RuntimeException(NOT_VALID_DELIMITER);
        }
    }

    private static void validateDelimiterNotNumber(String customDelimiter) {
        if (Character.isDigit(customDelimiter.charAt(DELIMITER_INDEX))) {
            throw new RuntimeException(NO_NUMBER_AS_DELIMITER);
        }
    }

    private static int getTotal(String[] values) {
        int total = 0;
        for (String value : values) {
            total += getPositiverNumber(value);
        }
        return total;
    }

    private static int getPositiverNumber(String value) {
        int toInt = Integer.parseInt(value);
        validatePositiveNumber(toInt);
        return toInt;
    }

    private static void validatePositiveNumber(int toInt) {
        if (toInt < 0) {
            throw new RuntimeException(NOT_VALID_RANGE);
        }
    }

    private static String getDelimiter(String text) {
        String delimiter = text.substring(CUSTOM_START.length());
        return Pattern.matches("[*+^]", delimiter) ? "\\" + delimiter : delimiter;
    }
}
