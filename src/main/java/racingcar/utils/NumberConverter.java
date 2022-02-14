package racingcar.utils;

import static racingcar.utils.Validator.checkPositiveNumber;

public class NumberConverter {

    private static final String ERROR_NUMBER_NOT_DIGIT = "[ERROR] 횟수는 숫자로 입력해야 합니다.";


    public static int toInt(String text) {
        try {
            int parseInt = Integer.parseInt(text);
            checkPositiveNumber(parseInt);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_NOT_DIGIT);
        }
    }

}
