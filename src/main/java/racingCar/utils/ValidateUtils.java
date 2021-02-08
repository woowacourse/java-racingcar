package racingCar.utils;

import racingCar.exception.InvalidCarNameException;
import racingCar.exception.InvalidNumOfMoveException;

public class ValidateUtils {

    public static final int MIN_NUM_OF_CARS = 2;
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String ERROR_MESSAGE_CAR_NAMES_COUNT = "자동차 이름은 1개 이상이어야 합니다.";
    public static final String ERROR_MESSAGE_CAR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    public static final String ERROR_MESSAGE_CAR_NAME_NULL_OR_EMPTY = "자동차 이름은 공백이 안됩니다.";
    public static final String ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER = "시도횟수는 자연수이어야 합니다.";

    public static void validateCarNames(String[] carNames) {
        validateNumOfCarNames(carNames);
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateNumOfCarNames(String[] carNames) {
        if (carNames.length < MIN_NUM_OF_CARS) {
            throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAMES_COUNT);
        }
    }

    private static void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameNotEmpty(carName);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() >= MIN_NAME_LENGTH && carName.length() <= MAX_NAME_LENGTH) {
            return;
        }
        throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAME_LENGTH);
    }

    private static void validateCarNameNotEmpty(String carName) {
        if (!carName.isEmpty()) {
            return;
        }
        throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAME_NULL_OR_EMPTY);
    }

    public static void validateRacingRoundCount(String input) {
        int count = validateInteger(input);
        validateNotNegative(count);
    }

    private static void validateNotNegative(int count) {
        if (count > 0) {
            return;
        }
        throw new InvalidNumOfMoveException(ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER);
    }

    private static int validateInteger(String count) {
        try{
            return Integer.parseInt(count);
        } catch (NumberFormatException e){
            throw new InvalidNumOfMoveException(ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER);
        }
    }
}
