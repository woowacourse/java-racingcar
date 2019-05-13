package calculator;

public class Main {
    public static void main(String[] args) {
        int result;

        String expression = CalculatorView.input();
        if (ExpressionValidator.isValid(expression)) {
            StringCalculator stringCalculator = new StringCalculator(expression);
            result = stringCalculator.calculate();
            CalculatorView.output(result);
        }
    }
}
