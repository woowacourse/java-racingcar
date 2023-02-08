package racingcar.util;

import java.util.Arrays;

public class Validator {

    private static final String DELIMITER = ",";
    private Validator() {
    }

    public static String[] validateCarNames(String carNames) {
        String[] split = carNames.split(DELIMITER);
        validateCarNameLength(split);
        validateNoInput(split);
        return split;
    }

    public static int validateGameTime(String input) {
        int inputNumber = validateStringToInt(input);
        validateGameTimeRange(inputNumber);
        return inputNumber;
    }

    private static void validateGameTimeRange(int inputNumber) {
        if (inputNumber <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateStringToInt(String input) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return integer;
    }

    private static void validateNoInput(String[] split) {
        long noInputCount = Arrays.stream(split).filter(s -> s.trim().equals("")).count();
        if (noInputCount >= 1) {
            throw new IllegalArgumentException("");
        }
    }

    private static void validateCarNameLength(String[] split) {
        long count = Arrays.stream(split).filter(s -> s.length() >= 5)
                .count();
        if (count >= 1) {
            throw new IllegalArgumentException();
        }
    }
}
