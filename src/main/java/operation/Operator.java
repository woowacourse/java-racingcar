package operation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Double, Double, Double> expression;
    private static Map<String, Operator> operators = new HashMap<>();

    static {
        for (Operator value : Operator.values()) {
            operators.put(value.operator, value);
        }
    }

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;

    }

    private double calculate(double result, double number) {
        return this.expression.apply(result, number);
    }

    public static double doCalculator(String operator, double result, double number) {
        return operators.get(operator).calculate(result, number);
    }

}
