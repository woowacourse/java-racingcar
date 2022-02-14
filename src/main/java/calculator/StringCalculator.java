package calculator;

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
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private static String getDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITER;
        if (Pattern.matches(REGEX, input)) {
            delimiter = getCustomDelimiter(input);
        }
        return delimiter;
    }

    private static String substringRegexPart(String input, String delimiter) {
        if (!delimiter.equals(DEFAULT_DELIMITER)) {
            input = input.substring(VALID_REGEX_PART_LENGTH);
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
        Integer result = null;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("전달된 배열의 원소는 반드시 숫자여야 합니다.");
        }
        return result;
    }

    private static void checkElementsNotNull(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new RuntimeException("전달된 배열에 원소가 없습니다.");
        }
    }

    private static void checkPositiveNumber(Integer number) {
        if (number < 0) {
            throw new RuntimeException("음수 값은 포함될 수 없습니다.");
        }
    }

    private static void checkDelimiterLength(String input) {
        String regexPart = findRegexPart(input);
        hasRegex(regexPart);
        checkRegexLength(regexPart);
    }

    private static void checkDelimiterNotDigit(String delimiter) {
        if (Character.isDigit(delimiter.charAt(0))) {
            throw new RuntimeException("정수는 커스텀 구분자로 지정할 수 없습니다.");
        }
    }

    private static String findRegexPart(String input) {
        Matcher matcher = Pattern.compile(DELIMITER_REGEX).matcher(input);
        matcher.find();
        return matcher.group();
    }

    private static void hasRegex(String regexPart) {
        if (regexPart.length() < VALID_REGEX_PART_LENGTH) {
            throw new RuntimeException("커스텀 구분자가 입력되지 않았습니다.");
        }
    }

    private static void checkRegexLength(String regexPart) {
        if (regexPart.length() > VALID_REGEX_PART_LENGTH) {
            throw new RuntimeException("커스텀 구분자는 한 글자여야 합니다.");
        }
    }
}
