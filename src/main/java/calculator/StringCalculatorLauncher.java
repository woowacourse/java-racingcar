package calculator;

import java.util.*;

public class StringCalculatorLauncher {
    public static void main(String[] args) {
        doCalculate();
    }

    public static void doCalculate() {
        ExtractedInformation extractedInfo = ExtractedInformation.instantiateExtractor();
        int result = Calculator.calculate(extractedInfo);
        OutputView.printResult(result);
    }
}
