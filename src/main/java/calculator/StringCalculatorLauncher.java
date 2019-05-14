package calculator;

import java.util.*;

public class StringCalculatorLauncher {
    public static void main(String[] args) {
        doCalculate();
    }

    public static void doCalculate() {
        ExtractedInformation extractedInfo = ExtractedInformation.instantiateExtractor();
        OperatorMap functionMap = new OperatorMap();
        int result = Calculator.calculate(extractedInfo, functionMap);
        OutputView.printResult(result);
    }
}
