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
        String formula = sc.nextLine();
        return formula;
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public int calculFormulaWithEnum(String[] formula) {
        int result = Integer.parseInt(formula[0]);
        for (int i = 1; i < formula.length - 1; i++) {
            result = operMap.get(formula[i]).calculate(result, Integer.parseInt(formula[++i]));
        }
        return result;
    }

    public static void main(String[] args) {
        CalculatorLine calculatorLine = new CalculatorLine();
        System.out.println("한줄을 입력하세요 : (예 : 2 + 3 * 4 / 2)");
        int result = calculatorLine.calculFormulaWithEnum(calculatorLine.splitFormula(calculatorLine.inputFormula()));
        System.out.println("결과는 " + result + "입니다.");
    }

    /*public int calcul(int numL, String sign, int numR) {
        if (sign.equals("+")) {
            return numL + numR;
        }

        if (sign.equals("-")) {
            return numL - numR;
        }

        if (sign.equals("*")) {
            return numL * numR;
        }

        if (sign.equals("/")) {
            return numL / numR;
        }

        throw new IllegalArgumentException("유효하지 않은 값입니다.");
    }

    public int calculFormula(String[] formula) {
        int num = Integer.parseInt(formula[0]);
        for (int i = 1; i < formula.length - 1; i++) {
            num = calcul(num, formula[i], Integer.parseInt(formula[++i]));
        }
        return num;
    }*/
}
