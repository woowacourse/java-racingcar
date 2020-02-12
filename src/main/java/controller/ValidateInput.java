package controller;

import java.util.regex.Pattern;

public class ValidateInput {

    public static boolean checkNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOverZero(int count) {
        return count > 0;
    }

    public static int inputCount(String input) {
        if (isNotInt(input)) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력하였습니다.");
        }
        return Integer.parseInt(input);
    }

    private static boolean isNotInt(String input) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return !pattern.matcher(input).matches();
    }
}
