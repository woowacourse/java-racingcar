package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return calculate(splitNumbers(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.equals(CalculatorConstant.BLANK);
    }

    private static boolean checkInputType(String input) {
        checkMinus(input);
        if (isCustom(input)) {
            return true;
        }
        return false;
    }

    private static void checkMinus(String input) {
        if (input.contains(CalculatorConstant.MINUS)) {
            throw new RuntimeException(CalculatorConstant.MINUS_ERROR);
        }
    }

    private static boolean isCustom(String input) {
        if (input.contains(CalculatorConstant.CUSTOM_FLAG_LEFT) || input.contains(CalculatorConstant.CUSTOM_FLAG_RIGHT)) {
            return true;
        }
        return false;
    }

    private static String[] splitByCustom(String input) {
        Matcher m = Pattern.compile(CalculatorConstant.PATTERN_MATCHER).matcher(input);
        if (!m.find()) {
            throw new IllegalStateException(CalculatorConstant.DELIMITER_ERROR);
        }
        String customDelimiter = m.group(1);
        String[] numbers = m.group(2).split(customDelimiter);
        return numbers;
    }

    private static String[] splitByRegex(String input) {
        return input.split(CalculatorConstant.REGEX);
    }

    private static int calculate(String[] numbers) {
        int sum = 0;
        if (numbers.length == 1) {
            return makeInteger(numbers[0]);
        }
        for (String number : numbers) {
            sum += makeInteger(number);
        }
        return sum;
    }

    private static int makeInteger(String number) {
        return Integer.parseInt(number);
    }

    private static String[] splitNumbers(String input) {
        if (checkInputType(input)) {
            return splitByCustom(input);
        }
        return splitByRegex(input);
    }
}

