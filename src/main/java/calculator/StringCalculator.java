package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final int ONE = 1;

    public static int splitAndSum(String expression) {
        if (isBlank(expression)) {
            return 0;
        }
        if (isOnlyOneNumber(expression)) {
            return stringToInteger(expression);
        }
        Integer resultWithOtherDelimiter = splitWithOtherDelimiter(expression);
        if (resultWithOtherDelimiter != null) {
            return splitWithOtherDelimiter(expression);
        }
        String[] separatedNumber = expression.split(",|:");
        return addArrayElements(separatedNumber);
    }

    private static Integer splitWithOtherDelimiter(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return addArrayElements(tokens);
        }
        return null;
    }

    private static int addArrayElements(String[] array) {
        int result = 0;
        for (String str : array) {
            result += stringToInteger(str);
        }
        return result;
    }

    private static int stringToInteger(String str) {
        try {
            int number = Integer.parseInt(str);
            checkNegativeAndThrowException(number);
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new RuntimeException("숫자 이외의 값을 입력받았습니다.");
        }
    }

    private static void checkNegativeAndThrowException(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 입력받았습니다.");
        }
    }

    private static boolean isBlank(String s) {
        return s == null || s.isEmpty();
    }

    private static boolean isOnlyOneNumber(String s) {
        return s.length() == ONE;
    }
}
