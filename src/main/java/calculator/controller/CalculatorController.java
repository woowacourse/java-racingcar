package calculator.controller;

import calculator.model.Calculator;
import calculator.utils.InputValidator;
import calculator.view.OutputView;

public class CalculatorController {
    private static final int DEFAULT_NUMBER = 0;

    public void runCalculator(String input){
        Calculator calculator = new Calculator();

        if (InputValidator.isInputNullOrBlankOrEmpty(input)) {
            OutputView.showSum(DEFAULT_NUMBER);
            return;
        }
        OutputView.showSum(calculator.sumAndDivideInput(input));
    }
}
