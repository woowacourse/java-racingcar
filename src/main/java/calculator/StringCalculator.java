package calculator;

//import unitTestExercise.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringCalculator {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Map<String, Operation> operationMap = new HashMap<>();

    public StringCalculator() {
        operationMap.put("+", new Add());
        operationMap.put("-", new Subtract());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
    }

    private static String inputString() {
        return SCANNER.nextLine();
    }

    public static String[] splitString(String str){
        return str.split(" ");
    }

    public int calculate(String[] formula) {
        int result = Integer.parseInt(formula[0]);

        for(int i = 1, len = formula.length; i < len; i += 2){
            int value = Integer.parseInt(formula[i + 1]);
            result = operationMap.get(formula[i]).calculate(result, value);
        }

        return result;
    }

    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();
        System.out.println("사칙연산 공식을 입력해 주십시오 :");
        String raw = StringCalculator.inputString();
        String[] inputData = StringCalculator.splitString(raw);
        int result = calc.calculate(inputData);
        System.out.println(result);
    }
}