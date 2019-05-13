package stringcalc;

import java.util.Scanner;

public class StringCalculator {
    private static final Scanner SCANNER = new Scanner(System.in);

    String getUserInput() {
        return SCANNER.nextLine();
    }

    protected int calculate(String userInput) {
        String[] splitUserInput = splitUserInput(userInput);
        int result = Integer.parseInt(splitUserInput[0]);

        for (int i = 1; i < splitUserInput.length; i += 2) {
            String operator = splitUserInput[i];
            int operand = Integer.parseInt(splitUserInput[i + 1]);
            result = matchOperator(result, operator, operand);
        }

        return result;
    }

    private int matchOperator(int result, String operator, int operand) {
        if (operator.equals("+")) {
            return result + operand;
        }

        if (operator.equals("-")) {
            return result - operand;
        }

        if (operator.equals("*")) {
            return result * operand;
        }

        return result / operand;
    }

    private String[] splitUserInput(String userInput) {
        return userInput.split(" ");
    }

    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();
        String userInput = calc.getUserInput();
        System.out.println(calc.calculate(userInput));
    }
}
