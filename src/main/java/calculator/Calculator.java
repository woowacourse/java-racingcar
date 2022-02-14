package calculator;

import java.util.List;

import static calculator.CalculatorValidator.*;

public class Calculator {

    private static final StringSplitter stringSplitter = StringSplitter.getInstance();

    public static int splitAndSum(String str) {
        if (isEmpty(str)) {
            return 0;
        }

        String[] tokens = stringSplitter.splitString(str);

        List<Integer> verifiedNumbers = getValidNumber(tokens);

        return getSum(verifiedNumbers);
    }

    private static int getSum(List<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
