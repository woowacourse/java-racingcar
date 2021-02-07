package stringcalculator.controller;

import stringcalculator.domain.StringCalculator;
import stringcalculator.view.InputView;
import stringcalculator.view.OutputView;

public class StringCalculatorController {
    public static void run() {
        int result = StringCalculator.splitAndSum(InputView.inputFormUser());
        OutputView.print(result);
    }
}