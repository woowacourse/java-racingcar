package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final String NOT_POSITIVE_MESSAGE = "음수입니다.";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String COMA_OR_COLON = ",|:";
    private static final int MIN_NUMBER = 0;
    private static Matcher matcher;

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitValues = getSplitValues(input);
        return calculate(splitValues);
    }

    private static int calculate(String[] values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            validateNumber(values[i]);
            result += Integer.parseInt(values[i]);
        }
        return result;
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException (NOT_NUMBER_MESSAGE);
        }
        if (Integer.parseInt(input) < MIN_NUMBER) {
            throw new RuntimeException(NOT_POSITIVE_MESSAGE);
        }
    }

    private static String[] getSplitValues (String input) {
        matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(COMA_OR_COLON);
    }
}
