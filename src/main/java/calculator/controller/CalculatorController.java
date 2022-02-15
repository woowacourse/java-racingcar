package calculator.controller;

import calculator.model.Calculator;
import calculator.utils.InputValidator;
import calculator.view.OutputView;

public class CalculatorController {

    public void runCalculator(String input){
        Calculator calculator = new Calculator();

        if (InputValidator.isInputNullOrBlankOrEmpty(input)) {
            OutputView.showSum(0);
            return;
        }
        OutputView.showSum(calculator.sumAndDivideInput(input));
    }
}
