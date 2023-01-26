package calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        return Arrays.stream(inputString.split("[,:]"))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}