import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String OR_OPERATOR = "|";
    public static final String NUMBER_EXPRESSION = "^~[0-9]+$";
    public static String delimiter = "," + OR_OPERATOR + ":";

    public static int calculate(String input) {
        String[] splitedInputs = split(input);
        validExceptPositiveNumberAndZero(splitedInputs);
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

    private static String removeCustomDelimiterWord(String input) {
        return input.substring(5);
    }

    public static void validExceptPositiveNumberAndZero(String[] inputs) {
        boolean isNotPositiveNumberAndZero = Arrays.stream(inputs)
                .anyMatch(input -> input.matches(NUMBER_EXPRESSION));
        if (isNotPositiveNumberAndZero) {
            throw new RuntimeException("숫자 이외의 값 혹은 음수가 입력되었습니다.");
        }
    }
}
