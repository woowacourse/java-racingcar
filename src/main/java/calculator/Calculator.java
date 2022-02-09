package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int sum(String input) {
        if (!validateNullAndBlank(input)) {
            return 0;
        }
        List<Integer> numbers = parseStringsToPositiveInts(splitByDelimiter(input));
        return sumNumbers(numbers);
    }

    private static boolean validateNullAndBlank(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] splitByDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static List<Integer> parseStringsToPositiveInts(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for(String stringNumber : stringNumbers) {
            numbers.add(getPositiveNumber(stringNumber));
        }
        return numbers;
    }

    private static int getPositiveNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        checkPositiveNumber(number);
        return number;
    }

    private static void checkPositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력될 수 없다.");
        }
    }

    private static int sumNumbers(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
