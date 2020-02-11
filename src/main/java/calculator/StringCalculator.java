package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    static final String COMA_OR_COLON = ",|:";

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
            throw new RuntimeException ("숫자가 아닙니다.");
        }
        if (Integer.parseInt(input) < 0)
            throw new RuntimeException ("음수입니다.");
    }

    private static String[] getSplitValues (String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(COMA_OR_COLON);
    }
}
