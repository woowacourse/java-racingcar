package racingcar.util;

import java.util.List;

public class Validator {
    private static final String ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하여야 합니다.";
    private static final String ERROR_CAR_NAME_BLANK = "자동차의 이름 입력은 공백일 수 없습니다.";
    private static final String BLANK = " ";
    private static final int CAR_NAME_LIMIT = 5;
    private static final String ERROR_NULL_EMPTY_MESSAGE = "빈칸 입력은 허용하지 않는다.";
    private static final String ERROR_INCLUDE_BLANK_MESSAGE = "내부에 공백이 포함될 수 없습니다.";
    public static final String ERROR_DUPLICATED_MESSAGE = "중복값을 입력할 수 없습니다.";

    public static void validateCarNames(List<String> carNames) {
        checkDuplicated(carNames);
        for (String carName : carNames) {
            validateInput(carName);
        }
    }

    private static void checkDuplicated(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_MESSAGE);
        }
    }

    public static void validateInput(String carName) {
        checkNullOrEmpty(carName);
        checkIncludeBlank(carName);
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

    public static void validateInputNumber(String inputRound) {
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
}
