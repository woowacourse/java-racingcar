package calculator;


//import exceptionsCalculator.CalculatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calculator {

    public static int calculate(ExtractedInformation extractedInfo, OperatorMap functionMap) {
        int result = extractedInfo.getInitialValue();
        for (int i = 0, n = extractedInfo.getSymbolSize(); i < n; i++) {
            result = functionMap.getFunction(extractedInfo.getSymbol(i)).calculate(result, extractedInfo.getNumber(i+1));
        }
        return result;
    }
}
