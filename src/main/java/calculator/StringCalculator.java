package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static final String DEFAULT_DELIMITER = "[,:]";
    static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    static final String NEGATIVE_NUM_ERROR = "Has Negative Number ";

    static int splitAndSum(String input) {
        if (checkIfNull(input) || checkIfEmpty(input)) {
            return 0;
        }
        return calculateTotalSum(getTokens(input));
    }

    static private boolean checkIfNull(String input) {
        return input == null;
    }

    static private boolean checkIfEmpty(String input) {
        return input.isEmpty();
    }

    static private int calculateTotalSum(String[] tokens) {
        return Arrays.stream(tokens)
                     .mapToInt(Integer::parseInt)
                     .peek(n -> {
                         if (n < 0) throw new RuntimeException(NEGATIVE_NUM_ERROR + n);
                     })
                     .sum();
    }

    static private String[] getTokens(String input) {
        Matcher matcher = getMatcher(input);
        if (matcher.find()) {
            return getTokensByCustomDelimiter(matcher);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    static private Matcher getMatcher(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
    }

    static private String[] getTokensByCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }
}
