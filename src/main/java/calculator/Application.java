package calculator;

import calculator.domain.StringCalculator;
import calculator.view.ConsoleOutput;
import calculator.view.UserInput;

public class Application {
    public static void main(String[] args) {
        runCalculator();
    }

    private static void runCalculator() {
        //try {
            String expression = UserInput.inputExpression();
            ConsoleOutput.printSum(StringCalculator.splitAndSum(expression));
        //} catch (Exception e) {
         //   System.out.println(e.getMessage());
         //   runCalculator();
        //}
    }
}
