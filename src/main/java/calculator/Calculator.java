package calculator;

import static calculator.CalculatorValidation.*;

public class Calculator {

    private static final StringSplitter stringSplitter = StringSplitter.getInstance();

    public static int splitAndSum(String str) {
        if (isEmpty(str)) {
            return 0;
        }

        if (isOnlyDigit(str)) {
            return Integer.parseInt(str);
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
