package cal.controller;

import cal.domain.InputValues;
import cal.domain.StringCalculator;
import cal.view.InputView;

public class Calculator {
    private static StringCalculator stringCalculator = new StringCalculator();

    public static void execute() {
        InputValues inputValues = InputView.InputNumbers();

        try {
            System.out.println(Calculator.calculate(inputValues));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            execute();
        }
    }

    private static int calculate(InputValues inputValues) throws ArithmeticException {
        return stringCalculator.calculate(inputValues.getInput());
    }
}
