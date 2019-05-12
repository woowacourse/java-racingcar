package calculator.calcinterface;

import java.util.HashMap;
import java.util.Map;

public class CalculatorLine {
    private String[] formulas;
    private Map<String, Operation> operationMap;

    public CalculatorLine(String formula) {
        this.formulas = splitFormula(formula);
        operationMap = new HashMap<>();
        operationMap.put("+", new Plus());
        operationMap.put("-", new Minus());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
    }

    private String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public int calculateFormula() {
        int result = Integer.parseInt(formulas[0]);
        for (int i = 1; i < formulas.length - 1; i++) {
            result = operationMap.get(formulas[i]).calculate(result, Integer.parseInt(formulas[++i]));
        }
        return result;
    }
}
