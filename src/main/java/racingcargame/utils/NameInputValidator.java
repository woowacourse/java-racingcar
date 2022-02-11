package racingcargame.utils;

import java.util.Arrays;

public class NameInputValidator {
    public static final String ERROR_CAR_NAME_IS_BLANK = "[error] 경주할 자동차 이름을 입력해주세요.";
    public static final String ERROR_CAR_NAME_IS_EMPTY = "[error] 입력된 자동차 이름 중 이름이 입력되지 않는 자동차가 있습니다.";
    public static final String ERROR_CAR_NAME_IS_SIZE_EXCEED_THAN_MAX = "[error] 자동차 이름을 1자이상, 5자 이하로 입력해주세요.";
    public static final String ERROR_SAME_CAR_NAME = "[error] 중복된 자동차 이름이 있습니다.";
    public static final String COMMA = ",";
    public static final int ZERO_EXIST = 0;
    public static final int CAR_NAME_MAX_SIZE = 5;

    private NameInputValidator() {
    }

    public static String validateCarNames(String carNames) {
        if (isNotBlankInCarNames(carNames) && isNotEmptyInCarNames(carNames)
                && isOverCarNamesLimitSize(carNames) && isNotSameCarNames(carNames)) {
            return carNames;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isNotBlankInCarNames(String carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_IS_BLANK);
        }
        return true;
    }

    private static boolean isNotEmptyInCarNames(String carNames) {
        String[] cars = carNames.split(COMMA);
        long count = Arrays.stream(cars)
                .filter(String::isBlank)
                .count();

        if (count > ZERO_EXIST) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_IS_EMPTY);
        }
        return true;
    }

    private static boolean isOverCarNamesLimitSize(String carNames) {
        String[] cars = carNames.split(COMMA);
        long count = Arrays.stream(cars)
                .filter(car -> car.length() > CAR_NAME_MAX_SIZE)
                .count();

        if (count > ZERO_EXIST) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_IS_SIZE_EXCEED_THAN_MAX);
        }
        return true;
    }

    private static boolean isNotSameCarNames(String carNames) {
        String[] cars = carNames.split(COMMA);
        long count = Arrays.asList(cars).stream()
                .distinct()
                .count();

        if (count < cars.length) {
            throw new IllegalArgumentException(ERROR_SAME_CAR_NAME);
        }
        return true;
    }
}
