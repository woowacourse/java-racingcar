package racingcargame.view;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class NameInputValidator {
    private static final String ERROR_CAR_NAME_IS_BLANK = "[error] 경주할 자동차 이름을 입력해주세요.";
    private static final String ERROR_CAR_NAME_IS_EMPTY = "[error] 입력된 자동차 이름 중 이름이 입력되지 않는 자동차가 있습니다.";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int ZERO_EXIST = 0;

    private NameInputValidator() {
    }

    public static String validateCarNamesInput(String carNames) {
        if (isBlankCarNames(carNames) || isEmptyCarNames(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    private static boolean isBlankCarNames(String carNames) {
        if (!StringUtils.isBlank(carNames)) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_CAR_NAME_IS_BLANK);
    }

    private static boolean isEmptyCarNames(String carNames) {
        String[] cars = carNames.split(CAR_NAME_DELIMITER);
        long count = Arrays.stream(cars)
                .filter(StringUtils::isBlank)
                .count();

        if (count == ZERO_EXIST) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_CAR_NAME_IS_EMPTY);
    }
}
