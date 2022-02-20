package racingcar.domain;

import java.util.List;

public class CarNameValidator {
    public static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static void validateCarName(String carName) throws RuntimeException {
        checkNameLength(carName);
        checkIsEmpty(carName);
        checkIsSpace(carName);
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new RuntimeException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private static void checkIsEmpty(String carName) {
        if (carName.equals("")) {
            throw new RuntimeException("모든 자동차 이름은 반드시 존재해야 합니다.");
        }
    }

    private static void checkIsSpace(String carName) {
        if (carName.trim().equals("")) {
            throw new RuntimeException("자동차 이름은 공백으로 설정할 수 없습니다.");
        }
    }

    public static void checkDuplication(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new RuntimeException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
