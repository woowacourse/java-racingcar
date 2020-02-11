import java.util.Arrays;

public class Calculator {

    public static final String COMMA = ",";
    public static final String COLUMN = ":";
    public static final String OR_OPERATOR = "|";

    public static int calculate(String input) {
        String[] splitedInputs = split(input);

        int result = Arrays.stream(splitedInputs)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();

        return result;
    }

    public static String[] split(String input) {
        return input.split(COMMA + OR_OPERATOR + COLUMN);
    }
}
