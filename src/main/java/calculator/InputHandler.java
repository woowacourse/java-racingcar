package calculator;

import java.util.Arrays;
import java.util.Scanner;

class InputHandler {
    private static final String[] operators = {"+", "-", "*", "/"};
    private static Scanner scanner = new Scanner(System.in);

    static String getInput() {
        System.out.println("식을 입력해주세요.");
        return scanner.nextLine();
    }

    static boolean canCalculate(String[] inputs) {
        boolean isOperator = false;
        boolean result = true;

        for (int i = 0; i < inputs.length && result; i++, isOperator = !isOperator) {
            result = checkString(isOperator, inputs[i]);
        }
        return result && (inputs.length > 0) && isOperator;
    }

    private static boolean checkString(boolean isOperator, String input) {
        if (isOperator)
            return Arrays.asList(operators).contains(input);
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
