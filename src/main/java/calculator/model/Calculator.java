package calculator.model;


public class Calculator {
    private ExtractedInformation extractedInfo;

    public Calculator(ExtractedInformation extractedInfo) {
        this.extractedInfo = extractedInfo;
    }

    public int calculate() {
        int result = extractedInfo.getInitialValue();
        for (int i = 0, n = extractedInfo.getCalculatingRounds(); i < n; i++) {
            result = extractedInfo.calculate(result, i);
        }
        return result;
    }
}
