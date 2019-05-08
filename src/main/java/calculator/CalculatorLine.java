package calculator;

import java.util.HashMap;
import java.util.Scanner;

public class CalculatorLine {

    HashMap<String, ArithmeticOp> operMap;

    public CalculatorLine() {
        operMap = new HashMap<>();
        operMap.put("+", ArithmeticOp.ADD);
        operMap.put("-", ArithmeticOp.SUB);
        operMap.put("*", ArithmeticOp.MULTI);
        operMap.put("/", ArithmeticOp.DIV);
    }

    public String inputFormula() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public int calcFormulaWithEnum(String[] formula) {
        int result = Integer.parseInt(formula[0]);
        for (int i = 1; i < formula.length - 1; i++) {
            result = operMap.get(formula[i]).calculate(result, Integer.parseInt(formula[++i]));
        }
        return result;
    }

    public static void main(String[] args) {
        CalculatorLine calculatorLine = new CalculatorLine();
        System.out.println("한줄을 입력하세요 : (예 : 2 + 3 * 4 / 2)");
        int result = calculatorLine.calcFormulaWithEnum(calculatorLine.splitFormula(calculatorLine.inputFormula()));
        System.out.println("결과는 " + result + "입니다.");
    }
}
