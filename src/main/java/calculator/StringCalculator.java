package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수 계산 불가능";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력 가능";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Parser parser = new Parser();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        splitAndSum(scanner.nextLine());
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            input = "0";
        }

        List<String> values = Arrays.asList(parser.split(input));
        List<Integer> nums = new ArrayList<>();

        for (String value : values) {
            validateNumber(value);
            validatePositive(Integer.parseInt(value));
            nums.add(Integer.parseInt(value));
        }

        return calculator.sum(nums);
    }

    public static void validateNumber(String value) {
        if (!Character.isDigit(value.charAt(0))) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validatePositive(Integer num) {
        if (num < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
