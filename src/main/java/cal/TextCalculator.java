package cal;

import java.util.HashMap;
import java.util.Map;

public class TextCalculator {
    private double result;
    private Map<String, Calculator> calculatorMap;

    public TextCalculator() {
        calculatorMap = new HashMap<>();
        calculatorMap.put("+", new PlusCalculator());
        calculatorMap.put("-", new MinusCalculator());
        calculatorMap.put("*", new MultiplyCalculator());
        calculatorMap.put("/", new DivideCalculator());
    }

    public double calculate(String inputText) {
        String tokens[] = inputText.trim().split(" ");

        result = toDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            detectOperator(tokens, i);
        }

        return result;
    }

    private void detectOperator(String[] tokens, int i) {
        result = calculatorMap.get(tokens[i]).calculate(result, Double.parseDouble(tokens[i + 1]));
    }

    private double toDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("적절한 입력이 아닙니다.");
        }
    }
}
