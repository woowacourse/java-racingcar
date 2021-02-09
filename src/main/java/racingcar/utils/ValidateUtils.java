package racingcar.utils;

import racingcar.exception.InvalidCarNameException;
import racingcar.exception.InvalidNumOfMoveException;

public class ValidateUtils {

    private static final int CAR_NAME_LENGTH_STARTINCLUSIVE = 1;
    private static final int CAR_NAME_LENGTH_ENDINCLUSIVE = 5;
    public static final int THE_LOWEST_NUM_OF_CAR_NAMES = 2;

    private ValidateUtils() {
    }

    public static void validateCarNames(String[] carNames) {
        validateNumOfCarNames(carNames);
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateNumOfCarNames(String[] carNames) {
        if (carNames.length < THE_LOWEST_NUM_OF_CAR_NAMES) {
            throw new InvalidCarNameException("자동차 이름은 1개 이상이어야 합니다.");
        }
    }

    private static void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameNotEmpty(carName);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() >= CAR_NAME_LENGTH_STARTINCLUSIVE
            && carName.length() <= CAR_NAME_LENGTH_ENDINCLUSIVE) {
            return;
        }
        throw new InvalidCarNameException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }

    private static void validateCarNameNotEmpty(String carName) {
        if (!carName.isEmpty()) {
            return;
        }
        throw new InvalidCarNameException("자동차 이름은 공백이 안됩니다.");
    }

    public static int validateRacingRoundCount(String input) {
        int count = validateInteger(input);
        validateNotNegitive(count);
        return count;
    }

    private static void validateNotNegitive(int count) {
        if (count > 0) {
            return;
        }
        throw new InvalidNumOfMoveException("시도횟수는 자연수이어야 합니다.");
    }

    private static int validateInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new InvalidNumOfMoveException("시도횟수는 숫자이어야 합니다.");
        }
    }
}
