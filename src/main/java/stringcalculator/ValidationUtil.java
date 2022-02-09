package stringcalculator;

import java.util.Arrays;

public class ValidationUtil {
    public static void checkNumber(String[] numbers) {
        try {
            Arrays.stream(numbers).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다!");
        }
    }
}
