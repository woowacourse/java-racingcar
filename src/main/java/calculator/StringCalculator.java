package calculator;

import java.util.Arrays;

public class StringCalculator {

    static int splitAndSum(String input) {
        if (checkIfNull(input) || checkIfEmpty(input)) {
            return 0;
        }
        String[] tokens = input.split("[,:]");
        return calculateTotalSum(tokens);
    }

    static private boolean checkIfNull(String input) {
        return input == null;
    }

    static private boolean checkIfEmpty(String input) {
        return input.isEmpty();
    }

    static private int calculateTotalSum(String[] tokens) {
        return Arrays.stream(tokens)
                     .mapToInt(Integer::parseInt)
                     .sum();
    }
}
