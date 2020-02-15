package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);

        if (m.find()) {
            return Stream.of(m.group(2).split(m.group(1)))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return Stream.of(expression.split(",|:"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
