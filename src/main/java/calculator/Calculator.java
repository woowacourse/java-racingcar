package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int sum(String input) {
        if (!validateNullAndBlank(input)) {
            return 0;
        }
        List<Integer> numbers = parseStringsToInts(splitByDelimiter(input));
        return sumNumbers(numbers);
    }

    private static boolean validateNullAndBlank(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] splitByDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static List<Integer> parseStringsToInts(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for(String stringNumber : stringNumbers) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }

    private static int sumNumbers(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
