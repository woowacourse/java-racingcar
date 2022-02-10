package calculator;

import java.util.regex.Matcher;

public class CalculatorValidation {

    private CalculatorValidation() {}

    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    public static boolean isOnlyDigit(String str) {
        try {
            isDigit(str);
            isNegativeNumber(str);

            return true;
        } catch (RuntimeException e){
            return false;
        }
    }

    public static void isValidTokens(String[] tokens) {
        for (String token : tokens) {
            isDigit(token);
            isNegativeNumber(token);
        }
    }

    public static void isValidMatcher(Matcher matcher) {
        if (!matcher.find()) {
            throw new RuntimeException("커스텀 형식에 맞지 않는 입력입니다.");
        }
    }

    private static void isDigit(String token) {
        try {
            Integer.parseInt(token);
        } catch(NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다!");
        }
    }

    private static void isNegativeNumber(String token) {
        int num = Integer.parseInt(token);

        if (num < 0){
            throw new RuntimeException("음수는 안됩니다!");
        }
    }

}
