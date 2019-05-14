package cal;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

final public class Calculator {
    private static Map<String, BiFunction<Double, Double, Double>> operators = new HashMap<>();

    static {
        operators.put("+", (num1, num2) -> num1 + num2);
        operators.put("-", (num1, num2) -> num1 - num2);
        operators.put("*", (num1, num2) -> num1 * num2);
        operators.put("/", (num1, num2) -> num1 / num2);
    }

    public static double calculate(String operator, double num1, double num2) {
        return operators.get(operator).apply(num1, num2);
    }
}
