package racingcar.utils;

public class NumberConverter {

    private static final String ERROR_NUMBER_OVER_ONE = "[ERROR] 횟수는 1 이상이어야 합니다.";
    private static final String ERROR_NUMBER_NOT_DIGIT = "[ERROR] 횟수는 숫자로 입력해야 합니다.";
    private static final int MIN_NUMBER = 0;

    public static int toInt(String text) {
        try {
            int parseInt = Integer.parseInt(text);
            checkPositiveNumber(parseInt);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_NOT_DIGIT);
        }
    }

    private static void checkPositiveNumber(int parseInt) {
        if (parseInt <= MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_OVER_ONE);
        }
    }
}
