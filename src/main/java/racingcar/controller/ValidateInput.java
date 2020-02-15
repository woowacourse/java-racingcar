package racingcar.controller;

public class ValidateInput {
    private static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 1이상 5이하만 가능합니다";
    public static final String INTEGER_ERROR_MESSAGE = "숫자가 아닌 문자를 입력하였습니다.";
    public static final String MIN_ROUND_NUMBER_ERROR_MESSAGE = "1이상의 숫자만 입력해야 합니다.";

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

    public static int ValidateCount(String input) throws Exception {
        int integerInput = Integer.parseInt(input);
        if (isUnderZero(integerInput)) {
            throw new IllegalArgumentException();
        }
        return integerInput;
    }
}
