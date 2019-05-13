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

    int matchOperator(int firstOperand, String operator, int secondOperand) {
        return Operator.stringToOperator(operator).calculate(firstOperand, secondOperand);
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
