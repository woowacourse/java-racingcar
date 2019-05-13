package cal;

public class TextCalculator {
    public static double calculate(String inputText) {
        String tokens[] = inputText.trim().split(" ");
        double result = toDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double number = toDouble(tokens[i + 1]);
            result = calculate(operator, result, number);
        }
        return result;
    }

    private static double calculate(String operator, double result, double number) {
        return Calculator.calculate(operator, result, number);
    }

    private static double toDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("적절한 입력이 아닙니다.");
        }
    }
}
