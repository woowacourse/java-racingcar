package racingcar.view;

import java.util.List;

public class Validator {

    private static String CAR_NAME_DELIMITER = ",";
    private static int CAR_NAME_MAX_LENGTH = 5;

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
}
