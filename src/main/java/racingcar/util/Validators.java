package racingcar.util;

import java.util.List;

public class Validators {
    private static final String ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하여야 합니다.";
    private static final String ERROR_CAR_NAME_BLANK = "자동차의 이름 입력은 공백일 수 없습니다.";
    private static final String ERROR_ROUND_NOT_NUMBER = "입력한 이동 숫자가 숫자의 형태가 아닙니다.";
    private static final String ERROR_ROUND_MINIMUM_ONE = "입력한 이동 숫자가 0 이하일수는 없습니다.";
    private static final String BLANK = " ";
    private static final int CAR_NAME_LIMIT = 5;
    private static final int ROUND_MINIMUM_ONE = 1;
    private static final String ERROR_CARS_NAME_DUPLICATED = "자동차의 이름에 중복이 있습니다.";

    public static void validateCarsName(List<String> carsName) {
        validateCarsNameDuplicated(carsName);
        for (String carName : carsName) {
            validateCarName(carName);
        }
    }

    private static void validateCarsNameDuplicated(List<String> carsName) {
        if (validateCarsNameSize(carsName)) {
            throw new IllegalArgumentException(ERROR_CARS_NAME_DUPLICATED);
        }
    }

    public static void validateCarName(String carName) {
        validateCarsNameLength(carName);
        validateCarsNameBlank(carName);
    }

    private static void validateCarsNameLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    private static void validateCarsNameBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_BLANK);
        }
    }

    private static boolean validateCarsNameSize(List<String> carsName) {
        return carsName.stream().distinct().count() != carsName.size();
    }

    public static void validateRound(String inputRound) {
        validateRoundNumber(inputRound);
        validateRoundMinimumOne(inputRound);
    }

    private static void validateRoundNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ROUND_NOT_NUMBER);
        }
    }

    private static void validateRoundMinimumOne(String inputRound) {
        if (Integer.parseInt(inputRound) < ROUND_MINIMUM_ONE) {
            throw new IllegalArgumentException(ERROR_ROUND_MINIMUM_ONE);
        }
    }
}
