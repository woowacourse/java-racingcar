package racingCar.utils;

import racingCar.exception.InvalidCarNameException;
import racingCar.exception.InvalidNumOfMoveException;

public class ValidateUtils {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String ERROR_MESSAGE_CAR_NAME_NULL_OR_EMPTY = "자동차 이름은 공백이 안됩니다.";
    private static final String ERROR_MESSAGE_ROUND_COUNT_NUMBER = "시도 횟수는 숫자이어야 합니다.";

    public static boolean isProperName(String carName) {
        return isProperLength(carName) && isNotBlank(carName);
    }

    private static boolean isProperLength(String carName) {
        try {
            return carName.length() >= MIN_NAME_LENGTH && carName.length() <= MAX_NAME_LENGTH;
        } catch (NullPointerException exception) {
            throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAME_NULL_OR_EMPTY);
        }
    }

    private static boolean isNotBlank(String carName) {
        return !carName.isEmpty();
    }

    public static int numberedCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new InvalidNumOfMoveException(ERROR_MESSAGE_ROUND_COUNT_NUMBER);
        }
    }
}
