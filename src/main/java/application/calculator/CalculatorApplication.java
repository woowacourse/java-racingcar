package application.calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private static Scanner scanner = new Scanner(System.in);

    private static void runCalculator() {
        try {
            String userInputText = getUserInputText();
            int calculateResult = StringCalculator.splitAndSum(userInputText);
            String result = makeResultString(userInputText, calculateResult);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            runCalculator();
        }
    }

    private static String makeResultString(String userInputText, int calculateResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(userInputText);
        sb.append(ConstantForCalculator.ARROW);
        sb.append(calculateResult);
        return sb.toString();
    }

    private static String getUserInputText() {
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        runCalculator();
    }
}
