package stringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int ZERO = 0;
    private static final int DELIMITER_INDEX = 1;
    private static final int TOKENS_INDEX = 2;
    private static final String MINUS_ERROR_MESSAGE = "[에러] 마이너스 값이 포함되었습니다.";

    public static int splitAndSum(String s) {
        if (checkEmpty(s)) {
            return 0;
        }

        String[] splitedNumbers = splitString(s);
        checkMinusValue(splitedNumbers);
        return sumNumbers(splitedNumbers);
    }

    private static boolean checkEmpty(String s){
        return s == null || s.isEmpty();
    }

    private static String[] splitString(String s){
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(s);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_INDEX);
            String[] numbers = m.group(TOKENS_INDEX).split(customDelimiter);
            return numbers;
        }

        return s.split(DEFAULT_DELIMITER);
    }

    private static int sumNumbers(String[] numbers){
        return Arrays.stream(numbers)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private static void checkMinusValue(String[] numbers){
        if (Arrays.stream(numbers)
            .anyMatch(number-> isMinus(Integer.parseInt(number)))) {
            throw new RuntimeException(MINUS_ERROR_MESSAGE);
        }
    }

    private static boolean isMinus(int number){
        return number < ZERO;
    }
}
