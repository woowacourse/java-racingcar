package stringcalculator;

import stringcalculator.controller.CalculatorController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        CalculatorController calculatorController = new CalculatorController(scanner);
        calculatorController.run();
    }
}
