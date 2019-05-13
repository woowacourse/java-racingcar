package calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Calculator {
    private static Map<String, Operator> operators = new HashMap<>();

    enum Operator {
        PLUS("+", (num1, num2) -> num1 + num2),
        MINUS("-", (num1, num2) -> num1 - num2),
        MULTI("*", (num1, num2) -> num1 * num2),
        DIVIDE("/", (num1, num2) -> num1 / num2);

        private String operator;
        private BiFunction<Integer, Integer, Integer> function;

        Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
            this.operator = operator;
            this.function = function;
        }
    }

    static {
        operators.put("+", Operator.PLUS);
        operators.put("-", Operator.MINUS);
        operators.put("*", Operator.MULTI);
        operators.put("/", Operator.DIVIDE);
    }

    public int calculateSingleExpression(int leftOperand, String operator, String rightOperandStr) {
        int rightOperand = Integer.parseInt(rightOperandStr);
        return operators.get(operator).function.apply(leftOperand, rightOperand);
    }

    public int calculateMultiExpression(String[] strings) {
        int result = Integer.parseInt(strings[0]);

        if (strings.length == 1)
            return result;

        for (int i = 1; i < strings.length; ) {
            result = calculateSingleExpression(result, strings[i], strings[i + 1]);
            i = i + 2;
        }

        return result;
    }

    public int calculate(String[] tokens) {
        return calculateMultiExpression(tokens);
    }
}
