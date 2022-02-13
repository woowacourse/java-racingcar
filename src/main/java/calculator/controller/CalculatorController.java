package calculator.controller;

import calculator.model.Calculator;
import calculator.utils.CalculatorInputValidator;
import calculator.view.OutputView;

public class CalculatorController {
    private final static CalculatorController CALCULATOR_CONTROLLER = new CalculatorController();

    Calculator calculator = new Calculator();

    private CalculatorController() {
    }

    public static CalculatorController getCalculatorController() {
        return CALCULATOR_CONTROLLER;
    }

    public void runCalculator(String input){
        if (CalculatorInputValidator.isInputNullOrBlankOrEmpty(input)) {
            OutputView.showSum(0);
            return;
        }
        OutputView.showSum(calculator.sumAndDivideInput(input));
    }
}
