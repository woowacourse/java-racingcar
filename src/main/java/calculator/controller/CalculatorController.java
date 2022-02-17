package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private static final int DEFAULT_NUMBER = 0;

    public void runCalculator(String input){
        Calculator calculator = new Calculator();

        if (InputValidator.isInputNullOrBlankOrEmpty(input)) {
            OutputView.showSum(DEFAULT_NUMBER);
            return;
        }

        if (InputView.hasCustomDelimiterInInput(input)) {
            OutputView.showSum(calculator.makeSumOfNumbers(InputView.dividesByCustomAndCheckValidate(input)));
            return;
        }
        OutputView.showSum(calculator.makeSumOfNumbers(InputView.divideNumbersByDelimiterAndCheckValidate(input)));
    }
}
