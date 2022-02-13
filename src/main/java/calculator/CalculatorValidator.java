package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class CalculatorValidator {

    private CalculatorValidator() {}

    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    public static void isValidMatcher(Matcher matcher) {
        if (!matcher.find()) {
            throw new RuntimeException("커스텀 형식에 맞지 않는 입력입니다.");
        }
    }

    public static List<Integer> getValidNumber(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            int validNumber = isValidToken(token);
            numbers.add(validNumber);
        }

        return numbers;
    }

    private static int isValidToken(String token) {
        int number = isDigit(token);
        isNegativeNumber(number);

        return number;
    }

    private static int isDigit(String token) {
        try {
            return Integer.parseInt(token);
        } catch(NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다!");
        }
    }

    private static void isNegativeNumber(int number) {
        if (number < 0){
            throw new RuntimeException("음수는 안됩니다!");
        }
    }

}
