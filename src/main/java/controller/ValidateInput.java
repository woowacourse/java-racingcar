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

    public static boolean isUnderZero(int round) {
        return round <= 0;
    }

    public static int ValidateCount(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력하였습니다.");
        }
        int integerInput = Integer.parseInt(input);
        if (isUnderZero(integerInput)) {
            throw new IllegalArgumentException("1이상의 숫자만 입력해야 합니다.");
        }
        return integerInput;
    }

    private static boolean isNotInteger(String input) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return !pattern.matcher(input).matches();
    }
}
