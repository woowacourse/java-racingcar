package calculator;

import calculator.exception.DelimiterLengthOverException;
import calculator.exception.DelimiterNotFoundException;
import calculator.exception.DelimiterNumericException;
import calculator.exception.ElementNotExistsException;
import calculator.exception.NumberNotPositiveException;
import calculator.exception.StringNotNumericException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String REGEX = "^//(.*)\n.*";
    private static final String DELIMITER_REGEX = "^//(.*)\n";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int VALID_REGEX_PART_LENGTH = 4;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        String delimiter = getDelimiter(input);
        input = substringRegexPart(input, delimiter);
        List<Integer> numbers = convertToNumberList(input.split(delimiter));
        return sumElements(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String getDelimiter(String input) {
        if (Pattern.matches(REGEX, input)) {
            return getCustomDelimiter(input);
        }
        return DEFAULT_DELIMITER;
    }

    private static String substringRegexPart(String input, String delimiter) {
        if (!delimiter.equals(DEFAULT_DELIMITER)) {
            return input.substring(VALID_REGEX_PART_LENGTH);
        }
        return input;
    }

    private static List<Integer> convertToNumberList(String[] array) {
        List<Integer> numbers = getNumbers(array);
        checkElementsNotNull(numbers);
        return numbers;
    }

    private static int sumElements(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            checkPositiveNumber(number);
            sum += number;
        }
        return sum;
    }

    private static String getCustomDelimiter(String input) {
        checkDelimiterLength(input);

        String delimiter = String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX));
        checkDelimiterNotDigit(delimiter);

        return delimiter;
    }

    private static List<Integer> getNumbers(String[] result) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : result) {
            numbers.add(stringToInteger(s));
        }
        return numbers;
    }

    private static Integer stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new StringNotNumericException(input);
        }
    }

    private static void checkElementsNotNull(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new ElementNotExistsException();
        }
    }

    private static void checkPositiveNumber(Integer number) {
        if (number < 0) {
            throw new NumberNotPositiveException(number);
        }
    }

    private static void checkDelimiterLength(String input) {
        String regexPart = findRegexPart(input);
        hasRegex(regexPart);
        checkRegexLength(regexPart);
    }

    private static void checkDelimiterNotDigit(String delimiter) {
        if (Character.isDigit(delimiter.charAt(0))) {
            throw new DelimiterNumericException(delimiter);
        }
    }

    private static String findRegexPart(String input) {
        Matcher matcher = Pattern.compile(DELIMITER_REGEX).matcher(input);
        matcher.find();
        return matcher.group();
    }

    private static void hasRegex(String regexPart) {
        if (regexPart.length() < VALID_REGEX_PART_LENGTH) {
            throw new DelimiterNotFoundException();
        }
    }

    private static void checkRegexLength(String regexPart) {
        if (regexPart.length() > VALID_REGEX_PART_LENGTH) {
            throw new DelimiterLengthOverException();
        }
    }
}
