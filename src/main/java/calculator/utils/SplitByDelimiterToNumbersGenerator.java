package calculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitByDelimiterToNumbersGenerator {
    private static final int SEPARATOR_END_SIGNATURE_LENGTH = 2;
    private static final String CUSTOM_SEPARATOR_START_SIGNATURE = "//";
    private static final String CUSTOM_SEPARATOR_END_SIGNATURE = "\\n";
    private static final String JOINING_SEPARATOR_DELIMITER = "|";
    private static final String BASIC_SEPARATOR_COMMA = ",";
    private static final String BASIC_SEPARATOR_COLON = ":";

    public static List<String> split(final String input) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON));
        String parameterString = getParameterString(input, delimiters);
        String delimiter = String.join(JOINING_SEPARATOR_DELIMITER, delimiters);
        return Arrays.asList(parameterString.split(delimiter));
    }

    private static String getParameterString(final String input, final List<String> delimiters) {
        if (hasCustomSeparator(input)) {
            String customDelimiter = input.substring(
                input.indexOf(CUSTOM_SEPARATOR_START_SIGNATURE) + CUSTOM_SEPARATOR_START_SIGNATURE.length(),
                input.indexOf(CUSTOM_SEPARATOR_END_SIGNATURE)
            );
            delimiters.add(customDelimiter);
            return input.substring(input.indexOf(CUSTOM_SEPARATOR_END_SIGNATURE) + SEPARATOR_END_SIGNATURE_LENGTH);
        }
        return input;
    }

    private static boolean hasCustomSeparator(final String input) {
        return input.contains(CUSTOM_SEPARATOR_START_SIGNATURE) && input.contains(CUSTOM_SEPARATOR_END_SIGNATURE);
    }
}
