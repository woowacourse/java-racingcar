package junit;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class CalculatorLine {

    HashMap<String, ArithmeticOp> calc;

    public CalculatorLine() {
        calc = new HashMap<>();
        calc.put("+", ArithmeticOp.add);
        calc.put("-", ArithmeticOp.sub);
        calc.put("*", ArithmeticOp.multi);
        calc.put("/", ArithmeticOp.div);
    }

    public String inputFormula() {
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        return formula;
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public int calcul(int numL, String sign, int numR) {
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
    }

    public int useEnumCal(String[] formula) {
        int num = Integer.parseInt(formula[0]);
        for (int i = 1; i < formula.length - 1; i++) {
            num = calc.get(formula[i]).calculate(num, Integer.parseInt(formula[++i]));
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
