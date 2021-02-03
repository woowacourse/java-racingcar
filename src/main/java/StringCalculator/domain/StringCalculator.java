package stringcalculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_FORMAT = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String delimiter = extractCustomDelimiterOrGetDefaultDelimiter(input);
        input = extractElementString(input);
        System.out.println(input);

        String[] inputs = input.split(delimiter);
        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String extractElementString(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }

    private static String extractCustomDelimiterOrGetDefaultDelimiter(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_FORMAT).matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private static boolean isNullOrBlank(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        return false;
    }
}
