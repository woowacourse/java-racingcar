package calculator.domain;

public class StringCalculator {
    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        Numbers numbers = NumberFactory.makeNumbers(expression);
        return numbers.calculateSum();
    }
}