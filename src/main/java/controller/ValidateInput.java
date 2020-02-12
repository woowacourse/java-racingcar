package controller;

import java.util.regex.Pattern;

public class ValidateInput {

    private static final String NUMBER_FORMAT = "^\\d+$";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 1이상 5이하만 가능합니다";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "숫자가 아닌 문자를 입력하였습니다.";
    private static final String MIN_ROUND_NUMBER_ERROR_MESSAGE = "1이상의 숫자만 입력해야 합니다.";

    public static String[] validateName(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
        return names;
    }

    public static boolean isUnderZero(int round) {
        return round <= GameManager.ZERO;
    }

    public static int ValidateCount(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
        int integerInput = Integer.parseInt(input);
        if (isUnderZero(integerInput)) {
            throw new IllegalArgumentException(MIN_ROUND_NUMBER_ERROR_MESSAGE);
        }
        return integerInput;
    }

    private static boolean isNotInteger(String input) {
        Pattern pattern = Pattern.compile(NUMBER_FORMAT);
        return !pattern.matcher(input).matches();
    }
}
