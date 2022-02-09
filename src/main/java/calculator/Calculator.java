package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final int DEFAULT_NUMBER = 0;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_INPUT_INDEX = 2;

    public static int sum(String input) {
        if (!validateNullAndBlank(input)) {
            return DEFAULT_NUMBER;
        }
        List<Integer> numbers = parseStringsToPositiveInts(splitInput(input));
        return sumNumbers(numbers);
    }

    private static boolean validateNullAndBlank(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] splitInput(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            return splitByDelimiter(m.group(CUSTOM_INPUT_INDEX), m.group(CUSTOM_DELIMITER_INDEX));
        }
        return splitByDelimiter(input, DEFAULT_DELIMITER);
    }

    private static String[] splitByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static List<Integer> parseStringsToPositiveInts(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(getPositiveNumber(stringNumber));
        }
        return numbers;
    }

    private static int getPositiveNumber(String stringNumber) {
        try {
            return parsePositiveInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("문자는 입력될 수 없다.");
        }
    }

    private static int parsePositiveInt(String stringNumber) {
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
