package calculator;

import static calculator.CalculatorValidation.isEmpty;
import static calculator.CalculatorValidation.isValidTokens;

public class Calculator {

    private static final StringSplitter stringSplitter = StringSplitter.getInstance();

    public static int splitAndSum(String str) {
        if (isEmpty(str)) {
            return 0;
        }

        String[] tokens = stringSplitter.parseString(str);

        isValidTokens(tokens);

        return getSum(tokens);
    }

    private static int getSum(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
