package calculator.domain;

public class StringCalculator {
    private static final String BLANK = " ";

    public int calculate(String input) {
        String[] values = splitWithBlank(input);
        String operator = null;
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i++) {
            if (isInteger(values[i])) {
                int nextValue = Integer.parseInt(values[i]);
                result = unitCalculate(result, operator, nextValue);
                continue;
            }
            operator = values[i];
        }
        return result;
    }

    private String[] splitWithBlank(String value) {
        return value.split(BLANK);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int unitCalculate(int result, String operator, int nextValue) {
        if (operator.equals("+")) {
            return (result + nextValue);
        }

        if (operator.equals("-")) {
            return (result - nextValue);
        }

        if (operator.equals("*")) {
            return (result * nextValue);
        }

        if (operator.equals("/")) {
            return (result / nextValue);
        }

        throw new IllegalArgumentException("기호로 +, -, *, / 를 입력해주세요");
    }
}
