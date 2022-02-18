package racingcar.util;

import java.util.List;

public class Validator {
    private static final String ERROR_LIST_INCLUDE_EMPTY_MESSAGE = "이름을 생략할 수 없습니다.";
    private static final String ERROR_DUPLICATED_MESSAGE = "중복값을 입력할 수 없습니다.";
    private static final String ERROR_INVALID_FORMAT_MESSAGE = "입력한 값이 숫자의 형태가 아닙니다.";
    private static final String ERROR_NULL_EMPTY_MESSAGE = "빈칸 입력은 허용하지 않습니다.";
    private static final String BLANK = " ";
    private static final String ERROR_INCLUDE_BLANK_MESSAGE = "내부에 공백이 포함될 수 없습니다.";

    private Validator() {
    }

    public static void validateCarNames(List<String> carNames) {
        checkCarNamesEmpty(carNames);
        checkDuplicated(carNames);
        for (String carName : carNames) {
            validateInput(carName);
        }
    }

    private static void checkCarNamesEmpty(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ERROR_LIST_INCLUDE_EMPTY_MESSAGE);
        }
    }

    private static void checkDuplicated(List<String> carNames) {
        long distinctCountOfCarNames = carNames.stream().distinct().count();
        if (distinctCountOfCarNames != carNames.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_MESSAGE);
        }
    }

    private static void validateInput(String carName) {
        checkNullOrEmpty(carName);
        checkIncludeBlank(carName);
    }

    public static void validateInputNumber(String inputRound) {
        checkNullOrEmpty(inputRound);
        checkValidFormat(inputRound);
    }

    private static void checkValidFormat(String inputNumber) {
        if (!(inputNumber.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException(ERROR_INVALID_FORMAT_MESSAGE);
        }
    }

    private static void checkNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_EMPTY_MESSAGE);
        }
    }

    private static void checkIncludeBlank(String input) {
        if (input.trim().contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_INCLUDE_BLANK_MESSAGE);
        }
    }
}
