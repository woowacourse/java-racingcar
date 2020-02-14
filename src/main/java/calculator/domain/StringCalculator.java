package calculator.domain;

public class StringCalculator {
    public static int splitAndSum(String expression) {
        if (expression.isBlank()) {
            return 0;
        }
        Numbers numbers = NumberFactory.makeNumbers(expression);
        return numbers.calculateSum();
    }
}