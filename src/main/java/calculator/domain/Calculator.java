package calculator.domain;

public class Calculator {
    public int run(String inputExpression) {
        Expression expression = new Expression(inputExpression);
        return expression.calculate();
    }
}
