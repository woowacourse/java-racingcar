package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("수식을 입력하여 주십시오.");
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(input.nextLine().split(" ")));
        System.out.println("감사합니다.\n결과값은 " + calculate(tokens)+ "입니다.");

    }

    public static int calculate(ArrayList<String> tokens) {
        final String symbol = "+-*/";
        int lhs = Integer.parseInt(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            int rhs = Integer.parseInt(tokens.get(i + 1));
            switch (symbol.indexOf(tokens.get(i))) {
                case 0:
                    lhs += rhs;
                    break;
                case 1:
                    lhs -= rhs;
                    break;
                case 2:
                    lhs *= rhs;
                    break;
                case 3:
                    lhs /= rhs;
                    break;
            }
        }
        return lhs;
    }
}