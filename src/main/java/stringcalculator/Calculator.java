package stringcalculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_STARTER = "//";
    private static final String CUSTOM_DELIMITER_TERMINATOR = "\\n";
    private static final String OR = "|";
    private static final String EMPTY_STRING = "";

    public static double calculate(String rawInput) {
        if (rawInput == null || rawInput.equals(EMPTY_STRING)) {
            return 0;
        }

        String delimiters = combineDelimiters(getNewDelimiter(rawInput));
        String pureExpression = getPureExpression(rawInput);
        List<String> operands = Arrays.asList(pureExpression.split(delimiters));
        return operands.stream()
                .mapToDouble(operand -> parseDoubleIfValid(operand))
                .sum();
    }

    private static Double parseDoubleIfValid(String operand) {
        Double doubledOperand = parseDoubleIfNumber(operand);
        if (doubledOperand < 0.0) {
            throw new RuntimeException("음수 계산은 지원하지 않습니다.");
        }
        return doubledOperand;
    }

    private static Double parseDoubleIfNumber(String operand) {
        try {
            return Double.parseDouble(operand);
        } catch (NumberFormatException e) {
            throw new RuntimeException("적절한 문자열을 입력해주세요");
        }
    }

    private static String combineDelimiters(String customDelimiter) {
        StringBuilder SB = new StringBuilder();
        SB.append(DEFAULT_DELIMITER);
        if (customDelimiter != null) {
            SB.append(OR);
            SB.append(customDelimiter);
        }
        return SB.toString();
    }

    private static String getNewDelimiter(String rawInput) {
        if (!hasCustomDelimiterRequest(rawInput)) {
            return null;
        }
        int startIndex = rawInput.indexOf(CUSTOM_DELIMITER_STARTER) + CUSTOM_DELIMITER_STARTER.length();
        int endIndex = rawInput.indexOf(CUSTOM_DELIMITER_TERMINATOR);
        return rawInput.substring(startIndex, endIndex);
    }

    private static String getPureExpression(String rawInput) {
        if (!hasCustomDelimiterRequest(rawInput)) {
            return rawInput;
        }
        return rawInput.substring(CUSTOM_DELIMITER_STARTER.length()
                + getNewDelimiter(rawInput).length()
                + CUSTOM_DELIMITER_TERMINATOR.length());
    }

    private static boolean hasCustomDelimiterRequest (String rawInput) {
        if (rawInput.length() > CUSTOM_DELIMITER_STARTER.length()) {
            return rawInput.substring(0, CUSTOM_DELIMITER_STARTER.length()).equals(CUSTOM_DELIMITER_STARTER);
        }
        return false;
    }
}
