package stringcalculator;

import java.util.Arrays;

public class ValidationUtil {
    public static void checkFormat(String[] input) {
        checkNumber(input);
        checkPositive(input);
    }

    public static void checkNumber(String[] numbers) {
        try {
            Arrays.stream(numbers).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다!");
        }
    }
    static void checkPositive(String[] numbers) {
        for (String number : numbers) {
            checkPositive(number);
        }
    }

    private static void checkPositive(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException("음수가 포함돼있습니다!");
        }
    }
}
