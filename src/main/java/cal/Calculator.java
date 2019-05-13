package cal;

public class Calculator {
    private int value;

    public int execute(String expression) {
        String[] parsedExpression = splitExpression(expression);
        value = parseInt(parsedExpression[0]);
        for (int i = 1; i < parsedExpression.length; i += 2) {
            String operator = parsedExpression[i];
            int number = parseInt(parsedExpression[i + 1]);
            calculate(operator, number);
        }
        return value;
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }

    private String[] splitExpression(String expression) {
        return expression.split(" ");
    }

    private void calculate(String symbol, int number) {
        Operator operator = Operator.findOperator(symbol);
        value = operator.calculator(value, number);
    }
}
