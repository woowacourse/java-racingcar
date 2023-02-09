package utils;

import static utils.Constant.MAX_NAME_SIZE;
import static utils.Constant.MIN_NAME_SIZE;
import static utils.Constant.MIN_TRYTIMES;
import static utils.ErrorMessage.WRONG_NAME_LENGTH;
import static utils.ErrorMessage.WRONG_TRYTIMES;

public class Validator {

    public static void validateCarNameLength(int size) {
        if (size <= MIN_NAME_SIZE || size > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(WRONG_NAME_LENGTH.of());
        }
    }

    public static void validateTryTimes(int tryTimes) {
        if (tryTimes < MIN_TRYTIMES) {
            throw new IllegalArgumentException(WRONG_TRYTIMES.of());
        }
    }
}
