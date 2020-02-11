package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static int splitAndSum(String expression) {
        if(expression == null || expression.isEmpty()) {
            return 0;
        }
        final String delimeter = ",|:";
        List<String> numbers = Arrays.asList(expression.split(delimeter));
        return numbers.stream().mapToInt(Integer::parseInt).sum();
    }
}
