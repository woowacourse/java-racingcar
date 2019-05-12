package cal;

import cal.utils.*;

import java.util.HashMap;
import java.util.Map;

public class CalculatorMapping {
    private static Map<String, Calculator> calculators = new HashMap<>();

    static {
        calculators.put("+", new PlusCalculator());
        calculators.put("-", new MinusCalculator());
        calculators.put("*", new MultiplyCalculator());
        calculators.put("/", new DivideCalculator());
    }

    public static Calculator getCalculator(String operator) {
        return calculators.get(operator);
    }
}
