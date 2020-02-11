package main;

import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        String value = InputView.inputValue();

        String[] numbers = Calculator.splitString(value);
        int result = Calculator.calculate(numbers);

        OutputView.printResult(result);
    }
}
