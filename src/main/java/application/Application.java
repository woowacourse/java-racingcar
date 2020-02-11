package application;

import application.calculator.Calculate;
import application.calculator.UserInputScanner;

public class Application {
    public static void runCalculator() {
        Calculate calculate = new Calculate();
        try {
            String userInput = UserInputScanner.inputStringEquation();
            int result = Calculate.calculation(calculate.makeNumbersList(userInput));
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        runCalculator();
    }
}
