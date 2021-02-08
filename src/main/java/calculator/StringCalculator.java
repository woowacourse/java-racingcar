package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String NEGATIVE_NUM_ERROR = "Has Negative Number ";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static int splitAndSum(String input) {
        if (checkIfNull(input) || checkIfEmpty(input)) {
            return 0;
        }
        return calculateTotalSum(getTokens(input));
    }

    private static boolean checkIfNull(String input) {
        return input == null;
    }

    private static boolean checkIfEmpty(String input) {
        return input.isEmpty();
    }

    private static int calculateTotalSum(String[] tokens) {
        return Arrays.stream(tokens)
                     .mapToInt(Integer::parseInt)
                     .peek(n -> {
                         if (n < 0) throw new RuntimeException(NEGATIVE_NUM_ERROR + n);
                     })
                     .sum();
    }

    private static String[] getTokens(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return getTokensByCustomDelimiter(matcher);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static Matcher getMatcher(String input) {
        return pattern.matcher(input);
    }

    private static String[] getTokensByCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2)
                .split(customDelimiter);
    }
}
