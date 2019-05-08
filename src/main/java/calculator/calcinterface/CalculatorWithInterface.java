package calculator.calcinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorWithInterface {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Operation operation;
    private Map<String, Operation> operationMap;

    public CalculatorWithInterface() {
        operationMap = new HashMap<>();
        operationMap.put("+", new Plus());
    }

    public String inputFormula() {
        return SCANNER.nextLine();
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public int calculateFormula(String[] formula) {
        int result = Integer.parseInt(formula[0]);
        for (int i = 1; i < formula.length - 1; i++) {
            result = operationMap.get(formula[i]).calculate(result, Integer.parseInt(formula[++i]));
        }
        return result;
    }
}
