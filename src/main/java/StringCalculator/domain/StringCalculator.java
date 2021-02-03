package stringcalculator.domain;

import java.util.Arrays;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if(isNullOrBlank(input)) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] inputs = input.split(DEFAULT_DELIMITER);

        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrBlank(String input) {
        if(input == null || input.isEmpty()){
            return true;
        }

        return false;
    }
}
