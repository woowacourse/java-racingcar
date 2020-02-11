package calculator.main;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String value = InputView.inputValue();

        String[] numbers = Calculator.splitString(value);
        int result = Calculator.calculate(numbers);

        OutputView.printResult(result);
    }
}
