package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class StringCalculator {
    private static List<String> tokens;
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int DELIMITER_POSITION = 1;
    private static final int TOKENS_POSITION = 2;
    private static final Pattern DELIMITER = Pattern.compile(CUSTOM_DELIMITER_REGEX);


    public static int splitAndSum(String text) {

        if (isEmpty(text)) {
            return 0;
        }

        if (isOneDigit(text)) {
            return Integer.parseInt(text);
        }

        divideByDelimiter(text);
        throwRuntimeExceptionWhenContainsNegative();
        return getSum();
    }

    private static void divideByDelimiter(String text) {
        Matcher m = DELIMITER.matcher(text);

        if (m.find()) {
            divideByCustomDelimiter(m);
            return;
        }

        divideByDefaultDelimiter(text);
    }

    private static void divideByCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(DELIMITER_POSITION);
        tokens = Arrays.asList(m.group(TOKENS_POSITION).split(customDelimiter));
    }

    private static void divideByDefaultDelimiter(String text) {
        tokens = Arrays.asList(text.split(DEFAULT_DELIMITER));
    }

    private static void throwRuntimeExceptionWhenContainsNegative() {

        if (tokens.stream()
                .filter(token -> Integer.parseInt(token) < 0)
                .findAny()
                .isPresent()) {
            throw new RuntimeException();
        }
    }

    private static int getSum() {
        return tokens.stream().mapToInt(Integer::valueOf).sum();
    }

    private static boolean isEmpty(String text) {

        if (text == null) {
            return true;
        }

        if (text.isEmpty()) {
            return true;
        }

        return false;
    }

    private static boolean isOneDigit(String text) {

        if (text.length() == 1 && Character.isDigit(text.charAt(0))) {
            return true;
        }

        return false;
    }
}
