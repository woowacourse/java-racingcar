package application;

import application.calculator.Calculate;
import application.calculator.InputStringEquation;

public class Application {

    public static void main(String[] args) {
        run();
    }
    public static void run() {
        Calculate calculate = new Calculate();
        try {
            String userInput = InputStringEquation.inputStringEquation();
            Calculate.calculation(calculate.extractExpression(userInput));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
