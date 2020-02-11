import java.util.Arrays;

public class Calculator {
    public static final String OR_OPERATOR = "|";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "`n";
    public static String delimiter = "," + OR_OPERATOR + ":";

    public static int calculate(String input) {
        String[] splitedInputs = split(input);
        validExceptNumber(splitedInputs);
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

   public static void validExceptNumber(String[] inputs) {
        String regExp = "^[0-9]+$";
        boolean a = Arrays.stream(inputs)
                .allMatch(input -> input.matches(regExp));
        if(a == false) {
            throw new RuntimeException("숫자 이외의 값입니다.");
        }
    }
}
