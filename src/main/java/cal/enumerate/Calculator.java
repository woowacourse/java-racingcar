package cal.enumerate;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Map<String, Operator> operators = new HashMap<>();

    static {
        for (Operator value : Operator.values()) {
            operators.put(value.operator, value);
        }
    }

    public static double calculate(String operator, double num1, double num2) {
        return operators.get(operator).calculate(num1, num2);
    }
}
