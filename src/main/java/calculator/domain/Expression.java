package calculator.domain;

public class Expression {
    private String expression;

    public Expression(String expression) {
        validateNull(expression);
        validateBlank(expression);
        this.expression = expression;
    }

    private void validateBlank(String expression) {
        if (expression.isEmpty()) {
            throw new ExpressionException(ExpressionException.NOT_BLANK);
        }
    }

    private void validateNull(String expression) {
        if (expression == null) {
            throw new ExpressionException(ExpressionException.NOT_NULL);
        }
    }

    public int calculate() {
        return Integer.parseInt(expression);
    }
}
