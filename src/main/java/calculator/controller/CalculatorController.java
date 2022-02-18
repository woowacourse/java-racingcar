package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private static final int DEFAULT_NUMBER = 0;

    public void runCalculator(String input){
        if (InputValidator.isInputNullOrBlankOrEmpty(input)) {
            OutputView.showSum(DEFAULT_NUMBER);
            return;
        }
        if (InputView.hasCustomDelimiterInInput(input)) {
            Calculator calculator = new Calculator(InputView.dividesByCustomAndCheckValidate(input));
            OutputView.showSum(calculator.makeSumOfNumbers());
            return;
        }
        Calculator calculator = new Calculator(InputView.divideNumbersByDelimiterAndCheckValidate(input));
        OutputView.showSum(calculator.makeSumOfNumbers());
    }
}
