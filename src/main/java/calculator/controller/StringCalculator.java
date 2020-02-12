package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculator {
    public static void run() {
        String value = InputView.inputValue();

        String[] numbers = Calculator.splitString(value);
        int result = Calculator.calculate(numbers);

        OutputView.printResult(result);
    }
}
