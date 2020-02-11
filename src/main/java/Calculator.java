import java.util.Arrays;

public class Calculator {

    public static final String COMMA = ",";
    public static final String COLUMN = ":";
    public static final String OR_OPERATOR = "|";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "`n";
    public static String delimiter = COMMA + OR_OPERATOR + COLUMN;

    public static int calculate(String input) {
        String[] splitedInputs = split(input);
        int result = Arrays.stream(splitedInputs)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();
        return result;
    }

    public static String[] split(String input) {
        if (checkCustomDelimiter(input)) {
            delimiter = input.substring(2, 3);
            input = removeCustomDelimiterWord(input);
        }
        return input.split(delimiter);
    }

    private static boolean checkCustomDelimiter(String input) {
        String prefix = input.substring(0, 2);
        String suffix = input.substring(3, 5);
        return prefix.equals(CUSTOM_DELIMITER_PREFIX)
                && suffix.equals(CUSTOM_DELIMITER_SUFFIX);
    }

    private static String removeCustomDelimiterWord(String input) {
        return input.substring(5);
    }
}
