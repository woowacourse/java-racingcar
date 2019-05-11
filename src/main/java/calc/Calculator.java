package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    private static double val;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("수식을 입력하여 주십시오.");
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(input.nextLine().split(" ")));
        try {
            calculateTokens(tokens);
            System.out.println("감사합니다.\n결과값은 " + val + "입니다.");
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    private static void calculateTokens(ArrayList<String> tokens) {
        val = .0;
        tokens.add(0, "+");
        calculate(tokens);
    }

    private static boolean calculate(ArrayList<String> tokens) {
        val = Operator.findOperator(tokens.remove(0)).calculate(val, Double.parseDouble(tokens.remove(0)));
        return tokens.isEmpty() || calculate(tokens);
    }
}