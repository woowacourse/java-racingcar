package study;

import java.util.stream.Stream;

public class Calculator {
    private static final String BLANK = "";
    private static final String CUSTOM_REGEX = "//";
    private static final String DEFAULT_REGEX = ",:";
    private static final RuntimeException RUNTIME_EXCEPTION = new RuntimeException("잘못 입력하셨습니다.");
    private static final int CUSTOM_REGEX_LENGTH = 4;

    public static int calculate(String input) {
        String regex = checkCustomRegex(BLANK, input);
        input = subStringInput(regex, input);

        return Stream.of(splitAsRegex(regex, input))
                .filter(Calculator::isNumber)
                .map(Integer::parseInt)
                .filter(Calculator::isPositive)
                .reduce(Integer::sum)
                .orElseThrow(() -> RUNTIME_EXCEPTION);
    }

    private static String checkCustomRegex(String regex, String input) {
        if (input.contains(CUSTOM_REGEX)) {
			regex = input.substring(2,3);
        }

        return regex;
    }

    private static String subStringInput(String regex, String input) {
        if (regex.equals(BLANK)) {
            return input;
        }

        return input.substring(CUSTOM_REGEX_LENGTH);
    }

    private static String[] splitAsRegex(String regex, String input) {
        return input.split("[" + regex + DEFAULT_REGEX + "]");
    }

    private static boolean isNumber(String input) {
        if (stringToCharacterStream(input).noneMatch(Character::isDigit)) {
            throw RUNTIME_EXCEPTION;
        }

        return true;
    }

    private static Stream<Character> stringToCharacterStream(String input) {
        return input.chars().mapToObj(number -> (char) number);
    }

    private static boolean isPositive(int number) {
        if (number < 0) {
            throw RUNTIME_EXCEPTION;
        }

        return true;
    }

}
