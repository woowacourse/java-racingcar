package calculator.model;


public class Calculator {
    private ExtractedInformation extractedInfo;
    private OperatorMap functionMap;

    public Calculator(ExtractedInformation extractedInfo, OperatorMap functionMap) {
        this.extractedInfo = extractedInfo;
        this.functionMap = functionMap;
    }

    public int calculate() {
        int result = extractedInfo.getInitialValue();
        for (int i = 0, n = extractedInfo.getCalculatingRounds(); i < n; i++) {
            result = extractedInfo.calculate(functionMap, result, i);
        }
        return result;
    }
}
