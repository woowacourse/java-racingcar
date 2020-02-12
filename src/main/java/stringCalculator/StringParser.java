package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static final String DEFAULT_DELIMITER_REGEX = ",|:";
    public static final String FRONT_SIGN = "//";
    public static final String BACK_SIGN = "\\n";
    public static final int TWO_STEP = 2;

    private StringParser() {
    }

    public static List<Integer> parse(String input) {
        String[] parsedArray;
        List<String> parsedList;

        if (hasSign(input)) {
            return parseWithCustomDelimiter(input);
        }

        parsedArray = input.split(DEFAULT_DELIMITER_REGEX);
        parsedList = Arrays.asList(parsedArray);

        return splitStringListToIntegerList(parsedList);
    }

    private static List<Integer> parseWithCustomDelimiter(String input) {
        int startOfCustomDelimiter = input.indexOf(FRONT_SIGN) + TWO_STEP;
        int endOfCustomDelimiter = input.indexOf(BACK_SIGN);
        String customDelimiter = input.substring(startOfCustomDelimiter, endOfCustomDelimiter);
        String query = input.substring(endOfCustomDelimiter + TWO_STEP);
        String[] split = query.split(DEFAULT_DELIMITER_REGEX + "|" + customDelimiter);
        List<String> result = Arrays.asList(split);
        return splitStringListToIntegerList(result);
    }

    private static List<Integer> splitStringListToIntegerList(List<String> split) {
        if (split.equals(Arrays.asList(new String[]{""}))) {
            return Arrays.asList(new Integer[]{0});
        }

        split.stream().forEach((t) -> checkIsPositiveNumber(t));

        return split.stream()
                .map((t) -> Integer.parseInt(t)).collect(Collectors.toList());
    }

    private static void checkIsPositiveNumber(String string) throws RuntimeException {
        string.chars().forEach((t) -> {
            checkIsDigit(t);
        });
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