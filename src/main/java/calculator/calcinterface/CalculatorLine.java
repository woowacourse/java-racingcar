package calculator.calcinterface;

import java.util.HashMap;
import java.util.Map;

public class CalculatorLine {
    private Map<String, Operation> operationMap;

    public CalculatorLine() {
        operationMap = new HashMap<>();
        operationMap.put("+", new Plus());
        operationMap.put("-", new Minus());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
    }

    public int calculateFormula(String formula) {
        String[] formulas = formula.split(" ");
        int result = Integer.parseInt(formulas[0]);
        for (int i = 1; i < formulas.length - 1; i++) {
            result = operationMap.get(formulas[i]).calculate(result, Integer.parseInt(formulas[++i]));
        }
        return result;
    }
}
