package cal;

final public class TextCalculator {
    private final static String DEFAULT_DELIMITER = " ";
    private final String text;

    public TextCalculator(final String text) {
        this.text = text.trim();
    }

    public double calculate() {
        String tokens[] = split(DEFAULT_DELIMITER);
        double result = toDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double number = toDouble(tokens[i + 1]);
            result = calculate(operator, result, number);
        }
        return result;
    }

    private String[] split(String delimiter) {
        return text.split(delimiter);
    }

    private  double calculate(String operator, double result, double number) {
        return Calculator.calculate(operator, result, number);
    }

    private  double toDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("적절한 입력이 아닙니다.");
        }
    }
}
