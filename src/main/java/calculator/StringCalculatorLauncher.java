package calculator;

import java.util.*;

public class StringCalculatorLauncher {
    public static void main(String[] args) {
        doCalculate();
    }

    public static void doCalculate() {
        String userInput = InputView.askAndReceiveExpression();
        List<String> expression = new ArrayList<>(Arrays.asList(userInput.split(" ")));
        Extractor extractor = Extractor.instantiateExtractor(expression);

    }
}
