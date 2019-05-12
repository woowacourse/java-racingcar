package calculator.domain;

public class StringCalculator {
    private static final String BLANK = " ";

    public int calculate(String input) {
        String[] values = splitWithBlank(input);
        Operator operator = null;
        Operand result = new Operand(values[0]);

        for (int i = 1; i < values.length; i++) {
            if (isInteger(values[i])) {
                Operand nextValue = new Operand(values[i]);
                result = new Operand(operator.calculate(result.intValue(), nextValue.intValue()));
                continue;
            }
            operator = Operator.fromSymbol(values[i]);
        }
        return result.intValue();
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
