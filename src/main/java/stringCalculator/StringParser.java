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
        if (hasSign(input)) {
            return parseWithCustomDelimiter(input);
        }

        return splitStringListToIntegerList(input.split(DEFAULT_DELIMITER_REGEX));
    }

    private static List<Integer> parseWithCustomDelimiter(String input) {
        int startOfCustomDelimiter = input.indexOf(FRONT_SIGN) + TWO_STEP;
        int endOfCustomDelimiter = input.indexOf(BACK_SIGN);
        String customDelimiter = input.substring(startOfCustomDelimiter, endOfCustomDelimiter);
        String[] result = input.substring(endOfCustomDelimiter + TWO_STEP, input.length())
                .split(DEFAULT_DELIMITER_REGEX + "|" + customDelimiter);
        return splitStringListToIntegerList(result);
    }

    private static List<Integer> splitStringListToIntegerList(String[] split) {
        if (split.equals(new String[]{""})) {
            return Arrays.asList(new Integer[]{0});
        }
        // 여기에 예외 처리
        try {
            return Arrays.asList(split)
                    .stream()
                    .map((t) -> Integer.parseInt(t))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println(Arrays.asList(split));
            System.err.println(e.getMessage());
            throw e;
        }
    }

    private static boolean hasSign(String input) {
        return input.contains(FRONT_SIGN) && input.contains(BACK_SIGN);
    }
}