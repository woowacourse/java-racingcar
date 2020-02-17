package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final int ONE = 1;
    public static final Pattern newDelimiterPattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String expression) {
        if (isBlank(expression)) {
            return 0;
        }
        return splitWithDelimiter(expression);
    }

    private static Integer splitWithDelimiter(String expression) {
        Matcher m = newDelimiterPattern.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return addArrayElements(tokens);
        }
        String[] separatedNum = expression.split(",|:");
        return addArrayElements(separatedNum);
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

}
