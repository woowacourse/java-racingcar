package application.calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private static Scanner scanner = new Scanner(System.in);

    private static void runCalculator() {
        try {
            String userInputText = getUserInputText();
            int result = StringCalculator.splitAndSum(userInputText);
            System.out.println(userInputText + " => " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            runCalculator();
        }
    }

    private static String getUserInputText() {
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        runCalculator();
    }
}
