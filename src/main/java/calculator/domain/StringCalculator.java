package calculator.domain;

public class StringCalculator {
    private static final String BLANK = " ";

    public int calculate(String input) {
        String[] values = splitWithBlank(input);
        Operator operator = null;
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i++) {
            if (isInteger(values[i])) {
                int nextValue = Integer.parseInt(values[i]);
                result = operator.calculate(result, nextValue);
                continue;
            }
            operator = Operator.fromSymbol(values[i]);
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
}
