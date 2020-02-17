package stringCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final String FRONT_SIGN = "//";
    public static final String BACK_SIGN = "\\n";
    public static final int TWO_STEP = 2;

    private StringParser() {
    }

    public static List<Integer> parse(String input) {
        if (hasSign(input)) {
            return parseWithCustomDelimiter(input);
        }

        return parseWithDefaultDelimiter(input);
    }

    private static List<Integer> parseWithDefaultDelimiter(String input) {
        String[] parsed = input.split(DEFAULT_DELIMITER_REGEX);

        return convertParsedStringsToIntegers(Arrays.asList(parsed));
    }

    private static List<Integer> parseWithCustomDelimiter(String input) {
        String query = getQuery(input);
        String customDelimiter = getCustomDelimiter(input);

        String[] parsed = query.split(DEFAULT_DELIMITER_REGEX + "|" + customDelimiter);

        return convertParsedStringsToIntegers(Arrays.asList(parsed));
    }

    private static String getQuery(String input) {
        int startOfQuery = input.indexOf(BACK_SIGN) + TWO_STEP;
        return input.substring(startOfQuery);
    }

    private static String getCustomDelimiter(String input) {
        int startOfCustomDelimiter = input.indexOf(FRONT_SIGN) + TWO_STEP;
        int endOfCustomDelimiter = input.indexOf(BACK_SIGN);

        return input.substring(startOfCustomDelimiter, endOfCustomDelimiter);
    }

    private static List<Integer> convertParsedStringsToIntegers(List<String> parsed) {
        if (parsed.get(0).isEmpty()) {
            return Collections.singletonList(0);
        }
        parsed.forEach(StringParser::checkIsPositiveNumber);
        return parsed.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static void checkIsPositiveNumber(String string) throws RuntimeException {
        string.chars().forEach(StringParser::checkIsDigit);
    }

    private static void checkIsDigit(int t) throws RuntimeException {
        if (!Character.isDigit(t)) {
            throw new RuntimeException();
        }
    }

    private static boolean hasSign(String input) {
        return input.contains(FRONT_SIGN) && input.contains(BACK_SIGN);
    }
}