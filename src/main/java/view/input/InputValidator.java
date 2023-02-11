package view.input;

import java.util.List;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_GAME_TRY_COUNT = 1;
    private static final int MAX_GAME_TRY_COUNT = 10000;

    private static final String CAR_NAME_EMPTY = "[ERROR] 자동차의 이름을 입력해주세요.";
    private static final String CAR_NAME_DUPLICATED = "[ERROR] 자동차의 이름이 중복되었습니다.";
    private static final String CAR_NAME_LENGTH_EXCEED = "[ERROR] 자동차 이름의 길이가 5글자를 넘습니다.";
    private static final String GAME_TRY_COUNT_OUT_OF_RANGE = "[ERROR] 시도 횟수가 1번 이상 10000번 이하여야 합니다.";
    private static final String IS_NOT_INTEGER = "[ERROR] 정수 이외의 다른 문자를 입력해서는 안됩니다.";

    public void validateCarName(final List<String> splitCarNames) {
        validateCarNameIsEmpty(splitCarNames);
        validateCarNameIsDuplicated(splitCarNames);
        for (String carName : splitCarNames) {
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameIsEmpty(final List<String> splitCarNames) {
        boolean isBlankExist = splitCarNames.stream()
                .anyMatch(String::isBlank);

        if (isBlankExist) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY);
        }
    }

    private void validateCarNameIsDuplicated(final List<String> splitCarNames) {
        boolean isDuplicated = splitCarNames.stream()
                .distinct()
                .count() != splitCarNames.size();

        if (isDuplicated) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED);
        }
    }

    private void validateCarNameLength(final String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEED);
        }
    }

    public void validateGameTry(final String gameTry) {
        validateIsInteger(gameTry);
        validateGameTryCount(Integer.parseInt(gameTry));
    }

    private void validateIsInteger(final String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_INTEGER);
        }
    }

    private void validateGameTryCount(final int gameTry) {
        if (gameTry < MIN_GAME_TRY_COUNT || gameTry > MAX_GAME_TRY_COUNT) {
            throw new IllegalArgumentException(GAME_TRY_COUNT_OUT_OF_RANGE);
        }
    }
}
