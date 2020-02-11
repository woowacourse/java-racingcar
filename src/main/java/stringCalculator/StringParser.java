package stringCalculator;

public class StringParser {
    public static final String DEFAULT_DELIMITER_REGEX = ",|:";
    public static final String FRONT_SIGN = "//";
    public static final String BACK_SIGN = "\\n";
    public static final int TWO_STEP = 2;

    private StringParser() {
    }

    public static String[] parse(String input) {
        if (hasSign(input)) {
            int startOfCustomDelimiter = input.indexOf(FRONT_SIGN) + TWO_STEP;
            int endOfCustomDelimiter = input.indexOf(BACK_SIGN);
            String customDelimiter = input.substring(startOfCustomDelimiter, endOfCustomDelimiter);
            return input.substring(endOfCustomDelimiter + TWO_STEP, input.length())
                    .split(DEFAULT_DELIMITER_REGEX + "|" + customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private static boolean hasSign(String input) {
        return input.contains(FRONT_SIGN) && input.contains(BACK_SIGN);
    }
}