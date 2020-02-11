package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class Calculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String CUSTOM_DELIMITER_STARTER = "//";
    private static final String CUSTOM_DELIMITER_TERMINATOR = "\\n";

    public static double calculate(String input) {
        String delimiters = combineDelimeters(getNewDelimiter(input));
        input = getPureExpression(input);
        List<String> operands = Arrays.asList(input.split(delimiters));

        return operands.stream()
                .mapToDouble(operand -> parseDoubleIfValid(operand))
                .sum();
    }

    private static Double parseDoubleIfValid(String operand) {
        Double output = Double.parseDouble(operand);
        if (output < 0.0) {
            throw new RuntimeException("음수 계산은 지원하지 않습니다.");
        }
        return output;
    }

    private static String combineDelimeters(String customDelimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COMMA);
        stringBuilder.append("|");
        stringBuilder.append(COLON);
        if (customDelimiter != null) {
            stringBuilder.append("|");
            stringBuilder.append(customDelimiter);
        }
        return stringBuilder.toString();
    }

    private static String getNewDelimiter(String input) {
        if (!hasCustomDelimiterRequest(input)) {
            return null;
        }
        int startIndex = input.indexOf(CUSTOM_DELIMITER_STARTER) + CUSTOM_DELIMITER_STARTER.length();
        int endIndex = input.indexOf(CUSTOM_DELIMITER_TERMINATOR);
        return input.substring(startIndex, endIndex);
    }

    private static String getPureExpression(String input) {
        if (!hasCustomDelimiterRequest(input)) {
            return input;
        }
        return input.substring(CUSTOM_DELIMITER_STARTER.length()
                + getNewDelimiter(input).length()
                + CUSTOM_DELIMITER_TERMINATOR.length());
    }

    private static boolean hasCustomDelimiterRequest (String input) {
        return input.substring(0, CUSTOM_DELIMITER_STARTER.length()).equals(CUSTOM_DELIMITER_STARTER);
    }
}
