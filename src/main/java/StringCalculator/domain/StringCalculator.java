package stringcalculator.domain;

import stringcalculator.exception.IllegalCustomDelimiterPositionException;

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

        String delimiter = DEFAULT_DELIMITER;

        if(isUsingCustomDelimiter(input)) {
            checkPrefixedCustomDelimiterFormat(input);
            delimiter = extractCustomDelimiter(input);
        }

        input = extractElementString(input);

        String[] inputs = input.split(delimiter);
        checkNegativeNumber(inputs);

        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String extractElementString(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }

    private static boolean isUsingCustomDelimiter(String input) {
        Matcher matcher = createCustomDelimiterMatcher(input);
        return matcher.find();
    }

    private static String extractCustomDelimiter(String input) {
        Matcher m = createCustomDelimiterMatcher(input);
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

    private static void checkPrefixedCustomDelimiterFormat(String input) {
        int index = -1;
        Matcher matcher = createCustomDelimiterMatcher(input);

        if (!matcher.find()) {
            index = matcher.start();
        }

        if (index != 0) {
            throw new IllegalCustomDelimiterPositionException();
        }
    }

    private static void checkNegativeNumber(String[] inputs) {
       long sizeOfNegative = Arrays.stream(inputs)
               .mapToInt(Integer::parseInt)
               .filter(input -> input < 0)
               .count();

       if (sizeOfNegative > 0) {
           throw new IllegalArgumentException();
       }
    }

    private static Matcher createCustomDelimiterMatcher(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_FORMAT).matcher(input);
    }
}
