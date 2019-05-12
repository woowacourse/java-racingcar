package calculator.domain;

public class StringCalculator {
    private static final String BLANK = " ";

    public static int calculate(String input) {
        String[] values = splitWithBlank(input);
        Operator operator = null;
        Operand result = new Operand(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            operator = Operator.fromSymbol(values[i]);
            Operand nextValue = new Operand(values[i + 1]);

            result = new Operand(operator.calculate(result.intValue(), nextValue.intValue()));
        }
        return result.intValue();
    }

    private static String[] splitWithBlank(String value) {
        return value.split(BLANK);
    }
}
