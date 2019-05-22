package calculator.controller;

import calculator.model.Calculator;
import calculator.model.ExtractedInformation;
import calculator.model.OperatorMap;
import racingcargame.view.OutputView;

public class StringCalculatorLauncher {
    public static void main(String[] args) {
        doCalculate();
    }

    public static void doCalculate() {
        ExtractedInformation extractedInfo = ExtractedInformation.instantiateExtractor();
        OperatorMap functionMap = new OperatorMap();
        Calculator calculator = new Calculator(extractedInfo, functionMap);
        int result = calculator.calculate();
        OutputView.printResult(result);
    }
}
