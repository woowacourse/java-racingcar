package calculator.calcinterface;

import calculator.calcenum.ArithmeticOp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalcMain {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Operation operation;

    Map<String, Operation> operationMap = new HashMap<>();;

    public CalcMain() {
        operationMap.put("+", new Plus());
    }

    public static void main(String[] args) {

    }

    public String inputFormula() {
        return SCANNER.nextLine();
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public int calcFormulaWithEnum(String[] formula) {
        int result = Integer.parseInt(formula[0]);
        for (int i = 1; i < formula.length - 1; i++) {
            result = operationMap.get(formula[i]).calculate(result, Integer.parseInt(formula[++i]));
        }
        return result;
    }
}
