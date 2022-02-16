package racingcar.view;

import java.util.List;

public class Validator {

    private static String CAR_NAME_DELIMITER = ",";
    private static int CAR_NAME_MAX_LENGTH = 5;
    private static int MIN_TRY_COUNT = 1;

    public static void validateCarNames(String carNames) {
        checkCarNamesEmpty(carNames);
        checkCarNameLength(carNames.split(CAR_NAME_DELIMITER));
    }

    private static void checkCarNamesEmpty(String stringNames) {
        if (stringNames == null || stringNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 값이 존재해야한다.");
        }
    }

    private static void checkCarNameLength(String[] carNameArray) {
        for(String carName : carNameArray) {
            if(carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
            }
        }
    }

    public static void validateTryCount(String tryCountText) {
        int tryCount = convertTryCountToInt(tryCountText);
        checkTryCountPositive(tryCount);
    }

    private static int convertTryCountToInt(String tryCountText) {
        try {
            return Integer.parseInt(tryCountText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자이어야 합니다.");
        }
    }

    public static void checkTryCountPositive(int tryCount) {
        if(tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도횟수는 0이하의 값이 들어올 수 없다.");
        }
    }
}
