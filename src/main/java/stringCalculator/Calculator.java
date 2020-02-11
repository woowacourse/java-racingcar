package stringCalculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static final String COMMA = ",";

    public static double calculate(String input) {
        List<String> operands = Arrays.asList(input.split(COMMA));
        return operands.stream()
                .mapToDouble(operand -> Double.parseDouble(operand))
                .sum();
    }
}
