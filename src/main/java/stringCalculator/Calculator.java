package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public static double calculate(String input) {
        List<String> operands = Arrays.asList(input.split(combineDelimeters()));
        return operands.stream()
                .mapToDouble(operand -> Double.parseDouble(operand))
                .sum();
    }

    private static String combineDelimeters() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COMMA);
        stringBuilder.append("|");
        stringBuilder.append(COLON);
        //stringBuilder.append("|");
        //stringBuilder.append(input.stream().collect(Collectors.joining("|")));
        return stringBuilder.toString();
    }
}
