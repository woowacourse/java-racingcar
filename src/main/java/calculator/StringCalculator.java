package calculator;

import java.util.Arrays;

public class StringCalculator {
    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        String[] values = value.split(",|:");

        int sum = Arrays.stream(values)
            .mapToInt(Integer::parseInt)
            .sum();
        return sum;
    }
}
