package calculator;

public class Main {
    public static void main(String[] args) {
        int result;

        String expression = View.input();
        if (Validator.isValid(expression)) {
            StringCalculator stringCalculator = new StringCalculator(expression);
            result = stringCalculator.calculate();
            View.output(result);
        }
    }
}
