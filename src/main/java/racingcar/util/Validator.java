package racingcar.util;

import java.util.List;

public class Validator {
    private static final String ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하여야 합니다.";
    private static final String ERROR_CAR_NAME_BLANK = "자동차의 이름 입력은 공백일 수 없습니다.";
    private static final String ERROR_ROUND_NOT_NUMBER = "입력한 이동 숫자가 숫자의 형태가 아닙니다.";
    private static final String ERROR_ROUND_MINIMUM_ONE = "입력한 이동 숫자가 0 이하일수는 없습니다.";
    private static final String BLANK = " ";
    private static final int CAR_NAME_LIMIT = 5;
    private static final int ROUND_MINIMUM_ONE = 1;
    private static final String ERROR_CARS_NAME_DUPLICATED = "자동차의 이름에 중복이 있습니다.";
    public static final String ERROR_NULL_EMPTY_MESSAGE = "빈칸 입력은 허용하지 않는다.";
    public static final String ERROR_INCLUDE_BLANK_MESSAGE = "내부에 공백이 포함될 수 없습니다.";
    public static final String ERROR_INVALID_RANGE_MESSAGE = "정상 범위(" + 1 + "이상)가 아닙니다";
    public static final int POSITIVE_NUMEBR_STANDARD = 1;

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

    public static void validateInputRound(String inputRound) {
        checkNullOrEmpty(inputRound);
        checkIncludeBlank(inputRound);
    }

    private static void checkNullOrEmpty(String inputRound) {
        if (inputRound == null || inputRound.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_EMPTY_MESSAGE);
        }
    }

    private static void checkIncludeBlank(String inputRound) {
        if (inputRound.trim().contains(" ")) {
            throw new IllegalArgumentException(ERROR_INCLUDE_BLANK_MESSAGE);
        }
    }

    public static void validateRound(int inputRound) {
        checkValidRangeOfInputRound(inputRound);
    }

    private static void checkValidRangeOfInputRound(int inputRound) {
        if (!(POSITIVE_NUMEBR_STANDARD <= inputRound)) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE_MESSAGE);
        }
    }
}
