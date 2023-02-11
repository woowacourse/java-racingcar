package racingcar.util;

import racingcar.view.ErrorMessage;

public class Validator {

    private static final int MIN_GAME_TIME = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private Validator() {
    }

    public static void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.CAR_NAME_LENGTH);
        }
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.NO_INPUT);
        }
    }

    public static int validateGameTime(String input) {
        int inputNumber = validateStringToInt(input);
        validateGameTimeRange(inputNumber);
        return inputNumber;
    }

    private static void validateGameTimeRange(int inputNumber) {
        if (inputNumber <= MIN_GAME_TIME) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }

    private static int validateStringToInt(String input) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.NOT_NUMBER);
        }
        return integer;
    }

}
