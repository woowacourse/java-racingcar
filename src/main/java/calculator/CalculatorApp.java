package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApp {
    public static void main(String[] args) {
        String expression = InputView.inputExpression();
        System.out.println(expression);

        Calculator calculator = new Calculator();
        int result = calculator.run();

        OutputView.printResult(result);
    }
}
