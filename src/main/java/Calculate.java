import java.util.List;

public class Calculate {

    private static final String NEGATIVE_EXCEPTION_MESSAGE = "%d 는 음수입니다.";

    public static int calculate(String input) {
        DelimiterAndTale delimiterAndTale = StringCalculate.removeHead(input);
        List<String> values = delimiterAndTale.split();
        return add(values);
    }

    private static int add(List<String> values) {
        int result = 0;
        for (String value : values) {
            int number = Integer.parseInt(value);
            checkNegative(number);
            result += number;
        }
        return result;
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format(NEGATIVE_EXCEPTION_MESSAGE, number));
        }
    }
}
