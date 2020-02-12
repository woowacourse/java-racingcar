package controller;

import java.util.regex.Pattern;

public class ValidateInput {

    public static String[] validateName(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return names;
    }

    public static boolean isOverZero(int count) {
        return count > 0;
    }

    public static int ValidateCount(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력하였습니다.");
        }
        return Integer.parseInt(input);
    }

    private static boolean isNotInteger(String input) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return !pattern.matcher(input).matches();
    }
}
