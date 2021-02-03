package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String OR = "|";

    public static int splitAndSum(String input) {
        if (!isEmpty(input)) {
            return 0;
        }

        String[] arr = split(input);
        for (String element: arr) {
            validateNegativeNumber(element);
        }

        return sum(arr);
    }

    private static String[] split(String input) {
        String delimeter = DEFAULT_DELIMITER;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            delimeter = delimeter.concat(OR + m.group(1));
            input = m.group(2);
        }
        return input.split(delimeter);
    }

    private static int sum(String[] arr) {
        int result = 0;
        for(String element : arr) {
            result += Integer.parseInt(element);
        }
        return result;
    }

    private static boolean isEmpty(String input) {
        if (input == null || input.equals("")) {
            return false;
        }
        return true;
    }

    private static void validateNegativeNumber(String s) {
        int number = Integer.parseInt(s);
        if (number < 0) {
            throw new RuntimeException("양수만 입력하세요.");
        }
    }
}
