package racingCar.utils;

import racingCar.exception.InvalidCarNameException;
import racingCar.exception.InvalidNumOfMoveException;

public class ValidateUtils {

    public static final int MIN_NUM_OF_CARS = 2;
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String ERROR_MESSAGE_CAR_NAMES_COUNT = "자동차 이름은 1개 이상이어야 합니다.";
    public static final String ERROR_MESSAGE_CAR_NAME_NULL_OR_EMPTY = "자동차 이름은 공백이 안됩니다.";
    public static final String ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER = "시도횟수는 자연수이어야 합니다.";


    public static String[] validateNumOfCarNames(String[] carNames) {
        if (carNames.length < MIN_NUM_OF_CARS) {
            throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAMES_COUNT);
        }
        return carNames;
    }

    public static boolean validateCarName(String carName) {
        return validateCarNameLength(carName) && validateCarNameNotEmpty(carName);
    }

    private static boolean validateCarNameLength(String carName) {
        try {
            return carName.length() >= MIN_NAME_LENGTH && carName.length() <= MAX_NAME_LENGTH;
        } catch (NullPointerException exception) {
            throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAME_NULL_OR_EMPTY);
        }
    }

    private static boolean validateCarNameNotEmpty(String carName) {
        return !carName.isEmpty();
    }

    public static int validateRacingRoundCount(String input) {
        int count = validateInteger(input);
        validateNotNegative(count);
        return count;
    }

    private static void validateNotNegative(int count) {
        if (count > 0) {
            return;
        }
        throw new InvalidNumOfMoveException(ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER);
    }

    private static int validateInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new InvalidNumOfMoveException(ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER);
        }
    }
}
