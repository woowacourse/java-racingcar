package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final int SEPARATOR_END_SIGNATURE_LENGTH = 2;
    private static final String CUSTOM_SEPARATOR_START_SIGNATURE = "//";
    private static final String CUSTOM_SEPARATOR_END_SIGNATURE = "\\n";
    private static final String JOINING_SEPARATOR_DELIMITER = "|";
    private static final String BASIC_SEPARATOR_COMMA = ",";
    private static final String BASIC_SEPARATOR_COLON = ":";
    private static final String ZERO_OR_POSITIVE_INTEGER_REGEX = "^(0|[1-9][0-9]*)$";
    private static final String INVALID_POSITIVE_INTEGER_ERROR_MESSAGE = "양의 정수를 입력 해주세요.";
    private static final int NULL_OR_EMPTY_VALUE = 0;

    public static int calculate(String input) {
        if (isNullOrEmpty(input)) {
            return NULL_OR_EMPTY_VALUE;
        }
        List<String> inputNumbers = split(input);
        checkRightPositiveInteger(inputNumbers);
        return inputNumbers.stream()
            .mapToInt(Integer::valueOf)
            .sum();
    }

    private static void checkRightPositiveInteger(List<String> inputNumbers) {
        inputNumbers.forEach(StringCalculator::checkNumberStringException);
    }

    private static void checkNumberStringException(String inputNumber) {
        if (!isZeroOrPositiveInteger(inputNumber)) {
            throw new RuntimeException(INVALID_POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isBlank();
    }

    private static boolean isZeroOrPositiveInteger(String input) {
        return input.matches(ZERO_OR_POSITIVE_INTEGER_REGEX);
    }

    private static List<String> split(String input) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON));
        String parameterString = getParameterString(input, delimiters);
        String delimiter = String.join(JOINING_SEPARATOR_DELIMITER, delimiters);
        return Arrays.asList(parameterString.split(delimiter));
    }

    private static String getParameterString(String input, List<String> delimiters) {
        if (hasCustomSeparator(input)) {
            String customDelimiter = input.substring(
                input.indexOf(CUSTOM_SEPARATOR_START_SIGNATURE) + CUSTOM_SEPARATOR_START_SIGNATURE.length(),
                input.indexOf(CUSTOM_SEPARATOR_END_SIGNATURE)
            );
            delimiters.add(customDelimiter);
            return input.substring(input.indexOf(CUSTOM_SEPARATOR_END_SIGNATURE) + SEPARATOR_END_SIGNATURE_LENGTH);
        }
        return input;
    }

    private static boolean hasCustomSeparator(String input) {
        return input.contains(CUSTOM_SEPARATOR_START_SIGNATURE) && input.contains(CUSTOM_SEPARATOR_END_SIGNATURE);
    }
}
