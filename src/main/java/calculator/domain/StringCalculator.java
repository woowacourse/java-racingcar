package calculator.domain;

public class StringCalculator {

    public static final String INVALID_VALUE_INCLUDED = "음수나 숫자 이외의 값이 포함되어 있습니다.";

    public static int splitAndSum(String expression) {
        if (expression.isBlank()) {
            return 0;
        }
        Numbers numbers = NumberFactory.makeNumbers(expression);
        return numbers.calculateSum();
    }
}