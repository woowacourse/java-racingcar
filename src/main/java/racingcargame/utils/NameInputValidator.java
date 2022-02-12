package racingcargame.utils;

import java.util.Arrays;

public class NameInputValidator {
    private static final String ERROR_CAR_NAME_IS_BLANK = "[error] 경주할 자동차 이름을 입력해주세요.";
    private static final String ERROR_CAR_NAME_IS_EMPTY = "[error] 입력된 자동차 이름 중 이름이 입력되지 않는 자동차가 있습니다.";
    private static final String ERROR_CAR_NAME_IS_SIZE_EXCEED_THAN_MAX = "[error] 자동차 이름을 1자이상, 5자 이하로 입력해주세요.";
    private static final String ERROR_SAME_CAR_NAME = "[error] 중복된 자동차 이름이 있습니다.";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int ZERO_EXIST = 0;
    private static final int CAR_NAME_MAX_SIZE = 5;

    private NameInputValidator() {
    }

    public static String validateCarNames(String carNames) {
        if (isBlankCarNames(carNames) || isEmptyCarNames(carNames)
                || isOverCarNamesLimitSize(carNames) || isSameCarNames(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    private static boolean isBlankCarNames(String carNames) {
        if (carNames != null) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_CAR_NAME_IS_BLANK);
    }

    private static boolean isEmptyCarNames(String carNames) {
        String[] cars = carNames.split(CAR_NAME_DELIMITER);
        long count = Arrays.stream(cars)
                .filter(String::isBlank)
                .count();

        if (count == ZERO_EXIST) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_CAR_NAME_IS_EMPTY);
    }

    private static boolean isOverCarNamesLimitSize(String carNames) {
        String[] cars = carNames.split(CAR_NAME_DELIMITER);
        long count = Arrays.stream(cars)
                .filter(car -> car.length() > CAR_NAME_MAX_SIZE)
                .count();

        if (count == ZERO_EXIST) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_CAR_NAME_IS_SIZE_EXCEED_THAN_MAX);
    }

    private static boolean isSameCarNames(String carNames) {
        String[] cars = carNames.split(CAR_NAME_DELIMITER);
        long count = Arrays.stream(cars)
                .distinct()
                .count();

        if (count == cars.length) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_SAME_CAR_NAME);
    }
}
