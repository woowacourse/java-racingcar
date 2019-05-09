package calculator.calcenum;

import java.util.HashMap;
import java.util.Scanner;

public class CalculatorLine {

    private HashMap<String, ArithmeticOp> opertaionMap;

    public CalculatorLine() {
        opertaionMap = new HashMap<>();
        opertaionMap.put("+", ArithmeticOp.ADD);
        opertaionMap.put("-", ArithmeticOp.SUB);
        opertaionMap.put("*", ArithmeticOp.MULTI);
        opertaionMap.put("/", ArithmeticOp.DIV);
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
            result = opertaionMap.get(formula[i]).calculate(result, Integer.parseInt(formula[++i]));
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
